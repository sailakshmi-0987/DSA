class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for(int num : gifts){
            pq.add((long) num);
        }
        int i = 1;
        while(i<=k){
            long cur = pq.poll();
            long floorvalue =(long) Math.floor(Math.sqrt(cur));

            pq.add(floorvalue);
            i++;
        }
        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        return ans;
    }
}