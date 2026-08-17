class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[n];
        for(int num : nums){
            pq.add(num);
        }
        int i = 0;
        while(!pq.isEmpty()){
            int n1 = pq.poll();
            int n2 = pq.poll();

            arr[i] = n2;
            arr[i+1] = n1;

            i = i+2;
        }
        return arr;
    }
}