import java.util.*;

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long validSubarrays = 0;
        int maxLeft = 0, secondMaxLeft = 0;
        long[] gains = new long[n + 1];

        
        List<Integer>[] conflicts = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            conflicts[i] = new ArrayList<>();
        }

      
        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            int r = Math.max(a, b);
            int l = Math.min(a, b);
            conflicts[r].add(l);
        }

      
        for (int r = 1; r <= n; ++r) {
            for (int l : conflicts[r]) {
                if (l > maxLeft) {
                    secondMaxLeft = maxLeft;
                    maxLeft = l;
                } else if (l > secondMaxLeft) {
                    secondMaxLeft = l;
                }
            }
            validSubarrays += r - maxLeft;
            gains[maxLeft] += (long)(maxLeft - secondMaxLeft);
        }

   
        long bestGain = 0;
        for (long g : gains) {
            bestGain = Math.max(bestGain, g);
        }

        return validSubarrays + bestGain;
    }
}
