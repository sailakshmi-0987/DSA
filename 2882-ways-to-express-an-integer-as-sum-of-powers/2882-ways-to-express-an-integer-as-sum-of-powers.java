class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfWays(int n, int x) {
        List<Integer> powers = new ArrayList<Integer>();
        int num=1;
        while(true){
            long power = (long)Math.pow(num,x);
            if(power>n)break;
            powers.add((int)power);
            num++;
        }
        int m = powers.size();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=m;i++){
            int val = powers.get(i-1);
            for(int target=1;target<=n;target++){
                dp[i][target]=dp[i-1][target];

                if(target>=val){
                    dp[i][target]=(dp[i][target]+dp[i-1][target-val])%MOD;
                }
            }
        }
        return dp[m][n];
    }
    /*public int helper(int currNum,int target,int x){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        int power = (int)Math.pow(currNum,x);
        if(power>target){
            return 0;
        }
        int take = helper(currNum+1,target-power,x);
        int notTake = helper(currNum+1,target,x);

        int count = (take+notTake)% MOD;
        return count;
    }*/
}