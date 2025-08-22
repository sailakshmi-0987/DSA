class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int nums_zeros =0;
        int maxlen = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                nums_zeros+=1;
            }
            while(nums_zeros>k){
                if(nums[left]==0){
                    nums_zeros-=1;
                }
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}