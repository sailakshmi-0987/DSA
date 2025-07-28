class Solution {
    private int maxOR = 0;
    private int count=0;
    private int[] nums;
    public int countMaxOrSubsets(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            maxOR |=nums[i];
        }
        this.nums=nums;
        dfs(0,0);
        return count;
    }
    public void dfs(int index,int currentOR){
        if(index==nums.length){
            if(currentOR==maxOR){
                count++;
            }
            return;
        }
        dfs(index+1,currentOR);
        dfs(index+1,currentOR|nums[index]);
    }
}