class Solution {
    public int longestSubarray(int[] nums) {
        int zeros_count = 0;
        int maxlen = 0;
        int left =0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeros_count+=1;
            }
            while(zeros_count>1){
                zeros_count-=(nums[left]==0)?1:0;
                left++;
            }
            maxlen = Math.max(maxlen,right-left);
        }
        return maxlen;
    }
}