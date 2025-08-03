class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        if(Math.abs(target)>total || (target+total)%2!=0) return 0;
        int S = (target+total)/2;
        int[] dp = new int[S+1];
        dp[0]=1;
        for(int num:nums){
            for(int s=S;s>=num;s--){
                dp[s]+=dp[s-num];
            }
        }
        return dp[S];
    }
}