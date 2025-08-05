class Solution {
    public int coinChange(int[] coins, int amount) {
        int n =coins.length;
        int[][] dp = new int[n][amount+1];
        int MAX = (int)1e9;
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0){
                dp[0][t]=t/coins[0];
            }
            else{
                dp[0][t]=MAX;
            }
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notTake = dp[i-1][t];
                int take = MAX;
                if(coins[i]<=t){
                    take = 1+dp[i][t-coins[i]];
                }
                dp[i][t]=Math.min(take,notTake);
            }
        }
        return dp[n-1][amount]>=MAX?-1:dp[n-1][amount];
    }
}