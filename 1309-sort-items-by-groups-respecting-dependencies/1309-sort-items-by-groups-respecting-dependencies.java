class Solution {
  
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        int newGroupIndex = m;
      
        
        List<Integer>[] groupItems = new List[n + m];
        int[] itemCountByGroup = new int[n];
        int[] groupDegree = new int[n + m];
        List<Integer>[] itemGraph = new List[n];
        List<Integer>[] groupGraph = new List[n + m];
      
        
        Arrays.setAll(groupItems, e -> new ArrayList<>());
        Arrays.setAll(itemGraph, e -> new ArrayList<>());
        Arrays.setAll(groupGraph, e -> new ArrayList<>());
    
       
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = newGroupIndex++;
            }
            groupItems[group[i]].add(i);
        }
      
        
        for (int i = 0; i < n; ++i) {
            for (int beforeItemIndex : beforeItems.get(i)) {
                if (group[i] == group[beforeItemIndex]) {
                    itemCountByGroup[i]++;
                    itemGraph[beforeItemIndex].add(i);
                } else {
                    groupDegree[group[i]]++;
                    groupGraph[group[beforeItemIndex]].add(group[i]);
                }
            }
        }
      
        
        List<Integer> allItems = new ArrayList<>();
        for (int i = 0; i < n + m; ++i) {
            allItems.add(i);
        }
        List<Integer> groupOrder = topologicalSort(groupDegree, groupGraph, allItems);
        if (groupOrder.isEmpty()) {
            return new int[0];
        }
      
       
        List<Integer> result = new ArrayList<>();
        for (int gid : groupOrder) {
            List<Integer> groupItemList = groupItems[gid];
            List<Integer> itemOrder = topologicalSort(itemCountByGroup, itemGraph, groupItemList);
            if (itemOrder.size() != groupItemList.size()) {
                return new int[0];
            }
            result.addAll(itemOrder);
        }
      
        
        return result.stream().mapToInt(i -> i).toArray();
    }
  
   
    private List<Integer> topologicalSort(int[] degree, List<Integer>[] graph, List<Integer> items) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i : items) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
      
        List<Integer> sortedItems = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sortedItems.add(current);
            for (int nextItem : graph[current]) {
                if (--degree[nextItem] == 0) {
                    queue.offer(nextItem);
                }
            }
        }
      
  
        return sortedItems.size() == items.size() ? sortedItems : Collections.emptyList();
    }
}
