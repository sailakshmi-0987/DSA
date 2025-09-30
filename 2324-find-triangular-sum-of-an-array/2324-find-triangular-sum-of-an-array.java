class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int[] comb = new int[n];
        comb[0] = 1; 
        for (int k = 1; k <= n - 1; k++) {
            for (int j = k; j >= 1; j--) {
                comb[j] = (comb[j] + comb[j - 1]) % 10;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + comb[i] * nums[i]) % 10;
        }
        return res;
    }
}