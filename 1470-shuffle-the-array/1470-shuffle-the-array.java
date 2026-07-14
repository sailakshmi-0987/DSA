class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans  = new int[2*n];
        ans[0] = nums[0];
        for(int i = 1; i<n ;i++){
            ans[i%n+i] = nums[i];
        }
        int j = 1;
        for(int k=n;k<2*n;k++){
            ans[k%n+j] = nums[k];
            j++;
        }

        return ans;
    }
}