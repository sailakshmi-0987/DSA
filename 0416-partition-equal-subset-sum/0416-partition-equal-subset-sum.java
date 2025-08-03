class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        if(total%2!=0){
            return false;
        }
        int target = total/2;
        Boolean[][] dp = new Boolean[n][target+1];
        return partition(n-1,target,nums,dp);
    }
    public boolean partition(int index,int target,int[] nums,Boolean[][] dp){
        if(index==0){
            return (nums[index]==target);
        }
        if(target==0){
            return true;
        }
        if(dp[index][target]!=null){
            return dp[index][target];
        }
        boolean notTaken = partition(index-1,target,nums,dp);
        boolean taken = false;

        if(target>=nums[index]){
            taken = partition(index-1,target-nums[index],nums,dp);
        }

        return dp[index][target] = (taken || notTaken);
    }
}