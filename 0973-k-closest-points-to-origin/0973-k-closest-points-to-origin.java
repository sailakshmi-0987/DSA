class Solution {

    public int[][] kClosest(int[][] points, int k) {

        int[][] sol = new int[k][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                return (a[0] * a[0] + a[1] * a[1])
                     - (b[0] * b[0] + b[1] * b[1]);
            }
        );

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }

        int i = 1;

        while (i <= k) {
            sol[i - 1] = pq.poll();
            i++;
        }

        return sol;
    }
}