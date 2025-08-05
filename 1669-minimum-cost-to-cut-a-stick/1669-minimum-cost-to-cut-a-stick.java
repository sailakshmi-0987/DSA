class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] allcuts = new int[c+2];
        allcuts[0]=0;
        allcuts[c+1]=n;
        for(int i=0;i<c;i++){
            allcuts[i+1]=cuts[i];
        }
        Arrays.sort(allcuts);
        int[][] dp = new int[c+2][c+2];
        for(int len=2;len<=c+1;len++){
            for(int i=0;i+len<=c+1;i++){
                int j=i+len;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k =i+1;k<j;k++){
                    int cost = allcuts[j]-allcuts[i]+dp[i][k]+dp[k][j];
                    dp[i][j] = Math.min(dp[i][j],cost);
                }
            }
        }
        return dp[0][c+1];
    }
}