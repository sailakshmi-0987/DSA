class Solution {
    public int fillCups(int[] amount) {
        int n = amount.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : amount){
            if(num>0){
                pq.add(num);
            }
        }
        int sec = 0;
        while(pq.size()>=2){
            int first = pq.poll();
            int second = pq.poll();

            first--;
            second--;
            sec++;
            if(first>0){
                pq.add(first);
            }
            if(second>0){
                pq.add(second);
            }
        }
         if (!pq.isEmpty()) {
            sec += pq.poll();
        }
        return sec;
    }
}