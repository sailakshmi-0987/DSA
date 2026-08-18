class Solution {

    public int largestInteger(int[] nums, int k) {

        int[] freq = new int[51];
        int lar = -1;

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        int maxE = 0;

        for (int i = 0; i < nums.length; i++) {
            maxE = Math.max(maxE, nums[i]);
        }

        int maxF = -1;

        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i]] == 1) {
                maxF = Math.max(maxF, nums[i]);
            }
        }

        if (k == 1) {

            lar = maxF;

        } else if (k == nums.length) {

            lar = maxE;

        } else {

            if (freq[nums[0]] > 1 && freq[nums[nums.length - 1]] > 1) {

                return -1;

            } else if (freq[nums[0]] > 1) {

                lar = nums[nums.length - 1];

            } else if (freq[nums[nums.length - 1]] > 1) {

                lar = nums[0];

            } else {

                lar = Math.max(nums[0], nums[nums.length - 1]);

            }
        }

        return lar;
    }
}