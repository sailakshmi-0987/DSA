import java.util.*;

class Solution {
    // Memoization map: key = [index, mask, canChange]
    private Map<List<Integer>, Integer> memo = new HashMap<>();
    private String s;
    private int k;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        return dfs(0, 0, 1);
    }

    private int dfs(int index, int mask, int canChange) {
        // Base case: when we reach the end, count one final partition
        if (index >= s.length()) {
            return 1;
        }

        // Memoization check
        List<Integer> state = List.of(index, mask, canChange);
        if (memo.containsKey(state)) {
            return memo.get(state);
        }

        // Character bitmask for current character
        int bit = 1 << (s.charAt(index) - 'a');
        int newMask = mask | bit;
        int maxPartitions;

        // Case 1: do not change current character
        if (Integer.bitCount(newMask) > k) {
            // start a new partition
            maxPartitions = dfs(index + 1, bit, canChange) + 1;
        } else {
            // continue current partition
            maxPartitions = dfs(index + 1, newMask, canChange);
        }

        // Case 2: change the current character (if still allowed)
        if (canChange == 1) {
            for (int c = 0; c < 26; ++c) {
                int newBit = 1 << c;
                int updatedMask = mask | newBit;

                if (Integer.bitCount(updatedMask) > k) {
                    // start a new partition with changed char
                    maxPartitions = Math.max(maxPartitions, dfs(index + 1, newBit, 0) + 1);
                } else {
                    // continue with current partition
                    maxPartitions = Math.max(maxPartitions, dfs(index + 1, updatedMask, 0));
                }
            }
        }

        memo.put(state, maxPartitions);
        return maxPartitions;
    }
}
