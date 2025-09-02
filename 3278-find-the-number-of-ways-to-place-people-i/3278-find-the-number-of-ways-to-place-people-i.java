class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 <= x2 && y1 >= y2 && (x1 < x2 || y1 > y2)) {
                    boolean valid = true;
                    int left = Math.min(x1, x2), right = Math.max(x1, x2);
                    int bottom = Math.min(y1, y2), top = Math.max(y1, y2);
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int x = points[k][0], y = points[k][1];
                        if (left <= x && x <= right && bottom <= y && y <= top) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }
        return count;
    }
}
