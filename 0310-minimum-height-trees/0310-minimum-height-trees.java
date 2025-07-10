class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> mht = new ArrayList<>();
        if(n==1){
            mht.add(0);
            return mht;
        }
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int[] edge:edges){
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            mht.clear();
            int count = queue.size();
            for(int i=0;i<count;i++){
                int leaf = queue.poll();
                mht.add(leaf);
                for(int neighbor:graph.get(leaf)){
                    degree[neighbor]--;
                    if(degree[neighbor]==1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return mht;
    }
}