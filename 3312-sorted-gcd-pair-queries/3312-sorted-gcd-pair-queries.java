class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
                int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums)
            freq[x]++;
        long[] exactPairs = new long[max + 1];
        for (int g = max; g >= 1; g--) {

            long count = 0;
            for (int multiple = g; multiple <= max; multiple += g) {
                count += freq[multiple];
            }

            long pairs = count * (count - 1) / 2;

            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                pairs -= exactPairs[multiple];
            }

            exactPairs[g] = pairs;
        }

        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exactPairs[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long target = queries[i] + 1; 
            int l = 1;
            int r = max;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (prefix[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}