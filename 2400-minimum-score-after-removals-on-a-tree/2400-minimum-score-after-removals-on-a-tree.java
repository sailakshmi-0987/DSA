class Solution {
    int[] inTime, outTime, subtreeXor;
    int time = 0;
    List<Integer>[] tree;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        inTime = new int[n];
        outTime = new int[n];
        subtreeXor = new int[n];
        
        dfs(0, -1, nums);

        int totalXor = subtreeXor[0];
        int minScore = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = i, b = j;

                int xor1, xor2, xor3;
                if (isAncestor(a, b)) {
                    xor2 = subtreeXor[b];
                    xor1 = subtreeXor[a] ^ xor2;
                } else if (isAncestor(b, a)) {
                    xor2 = subtreeXor[a];
                    xor1 = subtreeXor[b] ^ xor2;
                } else {
                    xor1 = subtreeXor[a];
                    xor2 = subtreeXor[b];
                }

                xor3 = totalXor ^ xor1 ^ xor2;
                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, max - min);
            }
        }

        return minScore;
    }

    private void dfs(int node, int parent, int[] nums) {
        inTime[node] = time++;
        subtreeXor[node] = nums[node];

        for (int nei : tree[node]) {
            if (nei == parent) continue;
            dfs(nei, node, nums);
            subtreeXor[node] ^= subtreeXor[nei];
        }

        outTime[node] = time++;
    }

    private boolean isAncestor(int u, int v) {
        
        return inTime[u] <= inTime[v] && outTime[u] >= outTime[v];
    }
}