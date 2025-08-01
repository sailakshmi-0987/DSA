class Solution {
    public int numSubmat(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    dp[i][j]=((j==0)?1:dp[i][j-1]+1);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)continue;
                int min=Integer.MAX_VALUE;
                for(int k =i;k>=0;k--){
                    if(dp[k][j]==0)break;
                    min = Math.min(min,dp[k][j]);
                    count+=min;
                }
            }
        }
        return count;
    }
}