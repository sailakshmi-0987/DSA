class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                if(a[0]!=b[0]){
                    return b[0]-a[0];
                }
                return a[1]-b[1];
            }
        );
        String[] ans = new String[n];
        for(int i =0;i<n;i++){
            pq.add(new int[]{score[i],i});
        }
        int k = 1;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(k==1){
                ans[cur[1]] = "Gold Medal";
            }
            else if(k==2){
                ans[cur[1]] = "Silver Medal";
            }
            else if(k==3){
                ans[cur[1]] = "Bronze Medal";
            }
            else{
               ans[cur[1]] = String.valueOf(k);
            }
            k++;
        } 
        return ans;
    }
}