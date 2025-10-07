class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); 
        TreeSet<Integer> dryDays = new TreeSet<>(); 

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) { 
                ans[i] = -1;
                if (fullLakes.containsKey(lake)) {
                    int lastRainDay = fullLakes.get(lake);
                    Integer dryDay = dryDays.higher(lastRainDay);
                    if (dryDay == null) return new int[0]; 
                    ans[dryDay] = lake; 
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i); 
            } else {
                dryDays.add(i);
                ans[i] = 1; 
            }
        }
        return ans;
    }
}