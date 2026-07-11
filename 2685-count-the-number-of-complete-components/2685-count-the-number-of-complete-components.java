class Solution {

    List<Integer>[] graph;

    boolean[] vis;

    int vertices;

    int edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);

        }

        vis = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                vertices = 0;
                edgeCount = 0;

                dfs(i);

                edgeCount /= 2;

                if (edgeCount == vertices * (vertices - 1) / 2)
                    ans++;
            }
        }

        return ans;
    }

    private void dfs(int node) {

        vis[node] = true;

        vertices++;

        edgeCount += graph[node].size();

        for (int nei : graph[node]) {

            if (!vis[nei])
                dfs(nei);

        }
    }
}