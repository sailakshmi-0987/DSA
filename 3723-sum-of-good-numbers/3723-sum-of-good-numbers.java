class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++){
            boolean good = true;
            if(i-k>=0 && nums[i]<=nums[i-k]){
                good = false;
            }
            if(i+k<n && nums[i]<=nums[i+k]){
                good = false;
            }
            if(good){
                sum+=nums[i];
            }
        }
        return sum;
    }
}