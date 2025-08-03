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
        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if (nums[0] <= target) dp[0][nums[0]] = true;

        for(int i=1;i<n;i++){
            for(int k=1;k<=target;k++){
                boolean notTaken = dp[i-1][k];
                boolean taken = false;
                if(nums[i]<=k){
                    taken = dp[i-1][k-nums[i]];
                }
                dp[i][k]=(taken||notTaken);
            }
        }
        return dp[n-1][target];
    }
  /*  public boolean partition(int index,int target,int[] nums,Boolean[][] dp){
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
    }*/
}