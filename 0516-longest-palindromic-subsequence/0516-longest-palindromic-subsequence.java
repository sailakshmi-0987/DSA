class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String str = new StringBuilder(s).reverse().toString();
        int n = str.length();
        return countSequence(m,n,s,str); 
    }
    public int countSequence(int m,int n,String text1,String text2){
        if(m==0 || n==0)return 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
      return dp[m][n];
    }
}