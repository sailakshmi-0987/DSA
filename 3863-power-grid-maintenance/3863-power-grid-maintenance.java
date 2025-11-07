class Solution {
    int[] parent, rank;

    int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (rank[a] < rank[b]) { parent[a] = b; }
        else if (rank[b] < rank[a]) { parent[b] = a; }
        else { parent[b] = a; rank[a]++; }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        rank = new int[c + 1];

        for (int i = 1; i <= c; i++) parent[i] = i;

        for (int[] e : connections) {
            union(e[0], e[1]);
        }

     
        Map<Integer, TreeSet<Integer>> comp = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            int r = find(i);
            comp.putIfAbsent(r, new TreeSet<>());
        }
        for (int i = 1; i <= c; i++) {
            comp.get(find(i)).add(i);
        }

        boolean[] offline = new boolean[c + 1];

        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];

            if (type == 1) { 
                if (!offline[x]) {
                    result.add(x);
                } else {
                    int root = find(x);
                    TreeSet<Integer> set = comp.get(root);

                    if (set.isEmpty()) result.add(-1);
                    else result.add(set.first());
                }
            } 
            else {  
                if (!offline[x]) {
                    offline[x] = true;
                    comp.get(find(x)).remove(x);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}