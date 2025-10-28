class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (simulate(nums, i, 1)) ans++;
                if (simulate(nums, i, -1)) ans++;
            }
        }
        return ans;
    }
    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone(); 
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir *= -1; 
                curr += dir;
            }
        }
        for (int x : arr) {
            if (x != 0) return false;
        }
        return true;
    }
}