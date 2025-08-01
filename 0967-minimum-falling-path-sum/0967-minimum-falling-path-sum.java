class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        if(m==0)return 0;
        int n= matrix[0].length;
        int[][] dp = new int[m][n];
        for(int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int s = dp[i-1][j];
                if(j-1>=0)s = Math.min(s,dp[i-1][j-1]);
                if(j+1<n)s=Math.min(s,dp[i-1][j+1]);

                dp[i][j]=matrix[i][j]+s;
            }
        }
        int min = dp[m-1][0];
        for(int j=1;j<n;j++){
            min = Math.min(min,dp[m-1][j]);
        }
        return min;
    }
}