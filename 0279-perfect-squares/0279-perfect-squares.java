class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        List<Integer> squares = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            squares.add(i*i);
        }
        for(int i =1;i<=n;i++){
            for(int sq : squares){
                if(sq>i)break;
                dp[i]=Math.min(dp[i],1+dp[i-sq]);
            }
        }
        return dp[n];
    }
}