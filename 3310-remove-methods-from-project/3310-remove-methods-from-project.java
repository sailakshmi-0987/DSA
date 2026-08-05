class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
        }

        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious);

        for (int[] edge : invocations) {

            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {


                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }

                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }


    private void dfs(int node,
                     List<List<Integer>> graph,
                     boolean[] suspicious) {

        suspicious[node] = true;

        for (int next : graph.get(node)) {

            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }
    }
