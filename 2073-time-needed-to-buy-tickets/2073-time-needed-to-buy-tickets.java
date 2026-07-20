class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<tickets.length;i++){
            q.offer(new int[]{i,tickets[i]});
        }
        int time = 0;
        while(!q.isEmpty()){
            int[] person = q.poll();
            int ticket = person[1];
            int index = person[0];
            ticket--;
            time++;
        
            if(ticket==0 && index==k){
                return time;
            }
            if(ticket>0){
                person[1] = ticket;
                q.offer(person);
            }
        }
        return time;
    }
}