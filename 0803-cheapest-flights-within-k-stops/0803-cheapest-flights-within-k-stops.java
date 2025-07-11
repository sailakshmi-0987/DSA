class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] flight: flights){
            int s = flight[0],d=flight[1],p=flight[2];
            graph[s].add(new int[]{d,p});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,src,0});
         int[][] visited = new int[n][k + 2];
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);
        visited[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1], stops = curr[2];

            if (node == dst) return cost;
            if (stops > k) continue;

            for (int[] nei : graph[node]) {
                int nextNode = nei[0], nextCost = nei[1];
                int newCost = cost + nextCost;
                if (newCost < visited[nextNode][stops + 1]) {
                    visited[nextNode][stops + 1] = newCost;
                    pq.offer(new int[]{newCost, nextNode, stops + 1});
                }
            }
        }

        return -1;

    
    }
}