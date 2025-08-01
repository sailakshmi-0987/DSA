class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int j=0;j<n;j++){
            dp[j] = triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
   /* public int total(int i,int j,int[][] dp,List<List<Integer>> triangle,int n){
        if(i==n-1){
            return triangle.get(n-1).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = triangle.get(i).get(j)+total(i+1,j,dp,triangle,n);
        int diag = triangle.get(i).get(j)+total(i+1,j+1,dp,triangle,n);

        return dp[i][j]=Math.min(down,diag);
    }*/
}