class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if(m==0 || n==0)return 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return count(m-1,n-1,text1,text2,dp);
    }
    public int count(int i,int j,String str1,String str2,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(str1.charAt(i)==str2.charAt(j)){
            return dp[i][j]=1+count(i-1,j-1,str1,str2,dp);
        }

        return dp[i][j]=Math.max(count(i,j-1,str1,str2,dp),count(i-1,j,str1,str2,dp));
    }
}