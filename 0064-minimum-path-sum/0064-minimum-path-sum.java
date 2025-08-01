class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return path(m-1,n-1,dp,grid);
    }
    public int path(int i,int j,int[][] dp,int[][] grid){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE/2;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=grid[i][j]+path(i-1,j,dp,grid);
        int left = grid[i][j]+path(i,j-1,dp,grid);

        return dp[i][j]=Math.min(up,left);
    }
}