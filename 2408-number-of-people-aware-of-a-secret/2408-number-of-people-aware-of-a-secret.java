class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = (int) 1e9 + 7;
        long[] dp = new long[n + 1];  
        dp[1] = 1;  
        long result = 0;
        for (int day = 1; day <= n; day++) {
            for (int shareDay = day + delay; shareDay < day + forget && shareDay <= n; shareDay++) {
                dp[shareDay] = (dp[shareDay] + dp[day]) % MOD;
            }
        }
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                result = (result + dp[day]) % MOD;
            }
        }

        return (int) result;
    }
}