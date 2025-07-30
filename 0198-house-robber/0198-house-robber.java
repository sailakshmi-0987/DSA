class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        return maxAmount(n-1,nums,dp);
    }
    public int maxAmount(int index,int[] nums,int[] dp){
        int n = nums.length;
        dp[0]=nums[0];
        int neg = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1)pick+=dp[i-2];
            int notpick = 0+dp[i-1];

            dp[i]=Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}