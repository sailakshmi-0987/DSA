class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            long required = (success + spell - 1) / spell; 
            if (required > Integer.MAX_VALUE) {
                res[i] = 0;
                continue;
            }
            int idx = lowerBound(potions, (int) required);
            res[i] = m - idx;
        }
        return res;
    }
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
