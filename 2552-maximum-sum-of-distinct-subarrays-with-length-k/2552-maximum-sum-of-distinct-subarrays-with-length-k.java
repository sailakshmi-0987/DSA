class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        if(k>nums.length) return 0L;
        long maxSum = 0L;
        long subarraySum =0L;
        int j =0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            subarraySum+=nums[i];
            if(i-j+1>k){
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j])==0){
                    map.remove(nums[j]);
                }
                subarraySum-= nums[j];
                j++;
            }
            if(i-j+1==k && map.size()==k){
                maxSum = Math.max(maxSum,subarraySum);
            }
        }
        return maxSum;
    }
}