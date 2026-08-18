class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                int asum = a[0]+a[1];
                int bsum = b[0]+b[1];
                if(asum!=bsum){
                    return asum - bsum;
                }
                return a[0]-b[0];
            }
        );
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<Math.min(k,nums1.length);i++){
            pq.add(new int[]{nums1[i],nums2[0],i,0});
        }
        for(int count=0;count<k;count++){
            int[] cur = pq.poll();
            int a = cur[0];
            int b = cur[1];
            int i = cur[2];
            int j = cur[3];
            ans.add(Arrays.asList(a,b));
            if(j+1<nums2.length){
                pq.add(new int[]{nums1[i],nums2[j+1],i,j+1});
            }
        }
        return ans;
    }
}