class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                int da = Math.abs(a[0] - x);
                int db = Math.abs(b[0] - x);
                if(da!=db){
                    return db - da;
                }
                return b[0] - a[0];
            }
        );
        for(int num : arr){
            pq.add(new int[]{num});
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll()[0]);
        }
        Collections.sort(ans);
        return ans;
    }
}