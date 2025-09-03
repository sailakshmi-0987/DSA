class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        // Step 1: Coordinate compression
        TreeSet<Integer> setX = new TreeSet<>();
        TreeSet<Integer> setY = new TreeSet<>();
        for (int[] p : points) {
            setX.add(p[0]);
            setY.add(p[1]);
        }

        Map<Integer, Integer> compX = new HashMap<>();
        Map<Integer, Integer> compY = new HashMap<>();
        int idx = 0;
        for (int x : setX) compX.put(x, idx++);
        idx = 0;
        for (int y : setY) compY.put(y, idx++);

        int sizeX = setX.size();
        int sizeY = setY.size();

        // Step 2: Build grid (1-based indexing for prefix sum ease)
        int[][] grid = new int[sizeX + 2][sizeY + 2];
        int[][] compPoints = new int[n][2];
        for (int i = 0; i < n; i++) {
            int cx = compX.get(points[i][0]);
            int cy = compY.get(points[i][1]);
            compPoints[i][0] = cx;
            compPoints[i][1] = cy;
            grid[cx + 1][cy + 1] += 1;
        }

        // Step 3: Build prefix sum matrix
        int[][] prefix = new int[sizeX + 2][sizeY + 2];
        for (int i = 1; i <= sizeX; i++) {
            for (int j = 1; j <= sizeY; j++) {
                prefix[i][j] = grid[i][j]
                              + prefix[i - 1][j]
                              + prefix[i][j - 1]
                              - prefix[i - 1][j - 1];
            }
        }

        // Helper: query rectangle sum safely
        java.util.function.Function<int[], Integer> query = (rect) -> {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            if (x1 > x2 || y1 > y2) return 0;
            return prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
        };

        // Step 4: Check all ordered pairs (Alice at i, Bob at j)
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x1 = compPoints[i][0];
            int y1 = compPoints[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x2 = compPoints[j][0];
                int y2 = compPoints[j][1];

                // Allow same row/column: Alice upper-left of Bob
                if ((x1 <= x2 && y1 >= y2) && (x1 < x2 || y1 > y2)) {
                    // query rectangle [x1..x2] × [y2..y1], convert to 1-based
                    int total = query.apply(new int[]{x1 + 1, y2 + 1, x2 + 1, y1 + 1});
                    if (total == 2) { // only Alice and Bob inside
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
