class Solution {

    int MOD = 1000000007;
    int[] nums;
    Long[][][] dp;

    public int subsequencePairCount(int[] nums) {

        this.nums = nums;

        dp = new Long[nums.length + 1][201][201];

        return (int) dfs(0, 0, 0);
    }

    private long dfs(int idx, int g1, int g2) {

        if (idx == nums.length) {

            if (g1 == g2 && g1 != 0)
                return 1;

            return 0;
        }

        if (dp[idx][g1][g2] != null)
            return dp[idx][g1][g2];

        long ans = 0;

        ans = dfs(idx + 1, g1, g2);

        ans = (ans + dfs(idx + 1, gcd(g1, nums[idx]), g2)) % MOD;

        ans = (ans + dfs(idx + 1, g1, gcd(g2, nums[idx]))) % MOD;

        dp[idx][g1][g2] = ans;

        return ans;
    }

    private int gcd(int a, int b) {

        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
}