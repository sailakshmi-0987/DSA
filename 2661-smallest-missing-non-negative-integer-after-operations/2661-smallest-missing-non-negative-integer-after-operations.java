class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];
        for (int num : nums) {
            int r = ((num % value) + value) % value;
            count[r]++;
        }

        int i = 0;
        while (true) {
            int r = i % value;
            if (count[r] > 0) {
                count[r]--; 
                i++;
            } else {
                return i; 
            }
        }

    }
}