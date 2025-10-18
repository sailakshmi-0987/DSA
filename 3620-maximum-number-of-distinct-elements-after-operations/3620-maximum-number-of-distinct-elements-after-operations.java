class Solution {
    public int maxDistinctElements(int[] nums, int k) {
         Arrays.sort(nums);
        long nextAvailable = Long.MIN_VALUE; 
        int count = 0;

        for (int num : nums) {
            long low = (long) num - k;
            long high = (long) num + k;

            if (nextAvailable < low) {
                nextAvailable = low;
            }

            if (nextAvailable <= high) {
                count++;
                nextAvailable++; 
            }
        }

        return count;
    }
}