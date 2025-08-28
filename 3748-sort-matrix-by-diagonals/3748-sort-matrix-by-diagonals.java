class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diagMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int d = i - j;
                diagMap.computeIfAbsent(d, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }
        for (int d : diagMap.keySet()) {
            List<Integer> list = diagMap.get(d);
            if (d >= 0) {
                list.sort(Collections.reverseOrder()); 
            } else {
                Collections.sort(list); 
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int d = i - j;
                grid[i][j] = diagMap.get(d).remove(0);
            }
        }
        return grid;
    }
}