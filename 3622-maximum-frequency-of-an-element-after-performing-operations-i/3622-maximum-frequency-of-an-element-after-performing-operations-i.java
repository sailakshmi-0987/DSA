class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        
        List<long[]> events = new ArrayList<>(n * 2);
        for (int x : nums) {
            long L = (long) x - k;
            long R = (long) x + k;
            events.add(new long[]{L, 1});
            events.add(new long[]{R + 1, -1});
        }
        events.sort((a, b) -> {
            if (a[0] < b[0]) return -1;
            if (a[0] > b[0]) return 1;
            return Long.compare(a[1], b[1]);
        });

       
        List<Long> distinctNums = new ArrayList<>();
        for (int x : freq.keySet()) distinctNums.add((long) x);
        Collections.sort(distinctNums);

        
        int ei = 0;
        long cover = 0;
        Map<Long, Integer> coverAtValue = new HashMap<>();
        long maxCover = 0;

       
        Collections.sort(distinctNums);
        for (long v : distinctNums) {
            while (ei < events.size() && events.get(ei)[0] <= v) {
                cover += events.get(ei)[1];
                ei++;
            }
           
            coverAtValue.put(v, (int) cover);
            if (cover > maxCover) maxCover = cover;
        }

        cover = 0;
        for (long[] ev : events) {
            cover += ev[1];
            if (cover > maxCover) maxCover = cover;
        }

        int ans = 0;
       
        ans = Math.max(ans, (int)Math.min(maxCover, (long)numOperations));

        
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            long v = e.getKey();
            int fixed = e.getValue();
            int intervalsCover = coverAtValue.getOrDefault(v, 0);
            int achievable = Math.min(intervalsCover, fixed + numOperations);
            ans = Math.max(ans, achievable);
        }

        return ans;
    }
}