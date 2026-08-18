class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                return a[0]-b[0];
            }
        );
        int n = matrix.length;
        for(int i=0;i<n;i++){
            pq.add(new int[]{matrix[i][0],i,0});
        }
        int ans = 0;
        for(int count = 0;count<k;count++){
            int[] cur = pq.poll();

            ans = cur[0];
            int row = cur[1];
            int col = cur[2];

            if (col + 1 < n) {
                pq.add(new int[]{
                    matrix[row][col + 1],
                    row,
                    col + 1
                });
            }
        }
        return ans;
    }
}