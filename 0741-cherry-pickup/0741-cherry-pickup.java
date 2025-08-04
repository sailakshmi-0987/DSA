class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[2*n-1][n][n];
        dp[0][0][0]=grid[0][0];

        for(int k=1;k<=n*2-2;k++){
            for(int i1=0;i1<n;i1++){
                for(int i2=0;i2<n;i2++){
                    int j1 = k-i1;
                    int j2 = k-i2;
                    dp[k][i1][i2]=Integer.MIN_VALUE;
                    if(j1<0 || j2<0 || j1>=n || j2>=n || grid[i1][j1]==-1 || grid[i2][j2]==-1){
                        continue;
                    }
                    int cherries = grid[i1][j1];
                    if(i1!=i2){
                        cherries+=grid[i2][j2];
                    }
                    for(int prev1 = i1-1;prev1<=i1;prev1++){
                        for(int prev2 = i2-1;prev2<=i2;prev2++){
                            if(prev1>=0 && prev2>=0){
                                dp[k][i1][i2] = Math.max(dp[k][i1][i2],dp[k-1][prev1][prev2]+cherries);
                            }
                        }
                    }
                }
            }
        }
        return Math.max(0,dp[2*n-2][n-1][n-1]);
    }
}