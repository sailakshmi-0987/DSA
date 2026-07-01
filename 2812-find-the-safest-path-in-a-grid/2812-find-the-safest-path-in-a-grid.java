import java.util.*;

class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        // Step 1: Calculate distance of every cell from nearest thief
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        // Insert all thieves into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        // Multi-source BFS
        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[r][c] + 1;

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 2: Binary Search on answer
        int low = 0;
        int high = 2 * n;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // Check if we can reach destination with safeness >= safe
    private boolean canReach(int[][] dist, int safe) {

        int n = dist.length;

        if (dist[0][0] < safe)
            return false;

        boolean[][] vis = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});

        vis[0][0] = true;

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            if (r == n - 1 && c == n - 1)
                return true;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        !vis[nr][nc] &&
                        dist[nr][nc] >= safe) {

                    vis[nr][nc] = true;

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}