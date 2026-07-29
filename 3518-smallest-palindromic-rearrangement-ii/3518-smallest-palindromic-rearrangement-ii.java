class Solution {
    private static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        char mid = 0;
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }

        if (countWays(half) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (mid != 0) {
            ans.append(mid);
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] freq) {
        int total = 0;
        for (int x : freq) total += x;

        long res = 1;

        for (int i = 0; i < 26; i++) {
            int f = freq[i];
            if (f == 0) continue;

            res *= comb(total, f);

            if (res > LIMIT) return LIMIT;

            total -= f;
        }

        return Math.min(res, LIMIT);
    }

    private long comb(int n, int r) {
        if (r > n) return 0;
        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans > LIMIT) return LIMIT;
        }

        return ans;
    }
}