class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
           List<int[]>[] graph = new ArrayList[n + 1]; // 1-indexed
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph[u].add(new int[]{v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,k});
       int[] dist = new int[n+1];
       for(int i=1;i<=n;i++){
         if(i!=k){
            dist[i]=Integer.MAX_VALUE;
         }
       }
        boolean[] vis = new boolean[n+1];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[1];
            int t = curr[0];

            if(!vis[node]){
                vis[node]=true;
            }
            for(int[] neighbor : graph[node]){
                
                    int dest = neighbor[0];
                    int weight = neighbor[1];
                    if(!vis[dest] && t+weight<dist[dest]){
                        dist[dest]=t+weight;
                        pq.offer(new int[]{dist[dest],dest});
                    }
                
                
            }
        }
        int maxTime=0;
        for(int i=1;i<=n;i++){
            if(!vis[i]) return -1;
            maxTime = Math.max(maxTime,dist[i]);
        }
        return maxTime;
    }
}