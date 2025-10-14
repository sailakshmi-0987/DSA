class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
           int n = nums.size();

        for (int a = 0; a <= n - 2 * k; a++) {
            boolean firstIncreasing = 
                IntStream.range(a, a + k - 1)
                         .allMatch(i -> nums.get(i) < nums.get(i + 1));

            boolean secondIncreasing = 
                IntStream.range(a + k, a + 2 * k - 1)
                         .allMatch(i -> nums.get(i) < nums.get(i + 1));

            if (firstIncreasing && secondIncreasing)
                return true;
        }

        return false;
    }
}