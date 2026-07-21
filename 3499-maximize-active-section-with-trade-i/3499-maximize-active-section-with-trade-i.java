class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ans = 0;
        int i = 0;
        int pre = Integer.MIN_VALUE;
        int mx = 0;

        while (i < s.length()) {
            int j = i + 1;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ans += len;
            } else {
                mx = Math.max(mx, pre + len);
                pre = len;
            }

            i = j;
        }

        return ans + mx;
    }
}