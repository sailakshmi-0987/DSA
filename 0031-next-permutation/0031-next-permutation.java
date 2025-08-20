class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = n-2;
        while(left>=0 && nums[left]>=nums[left+1]){
            left--;
        }
        if(left>=0){
            int right = n-1;
            while(nums[right]<=nums[left]){
                right--;
            }
            swap(nums,left,right);
        }
        reverse(nums,left+1,n-1);
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }
}