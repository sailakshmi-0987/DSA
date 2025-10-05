class Solution {
    int m, n;
    int[][] heights;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) dfs(i, 0, pacific, heights[i][0]);
        for (int j = 0; j < n; j++) dfs(0, j, pacific, heights[0][j]);
        for (int i = 0; i < m; i++) dfs(i, n-1, atlantic, heights[i][n-1]);
        for (int j = 0; j < n; j++) dfs(m-1, j, atlantic, heights[m-1][j]);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
     private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || r >= m || c < 0 || c >= n) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return; 

        visited[r][c] = true;
        for (int[] d : dirs) {
            dfs(r + d[0], c + d[1], visited, heights[r][c]);
        }
    }
}