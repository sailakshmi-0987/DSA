class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> s= new HashSet<>();
        s.add(nums[0]);

        int j=0,sum=nums[0],res=nums[0];
        for(int i=1;i<n;i++){
            if(!s.contains(nums[i])){
                sum+=nums[i];
                res=Math.max(res,sum);
                s.add(nums[i]);
            }else{
                while(nums[j]!=nums[i]){
                    sum-=nums[j];
                    s.remove(nums[j]);
                    j++;
                }
                j++;
            }
        }
        return res;
    }
}