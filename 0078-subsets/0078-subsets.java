class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }
    public static void backtrack(int start,int[] nums,List<Integer> s,List<List<Integer>> res){
        res.add(new ArrayList<>(s));
        for(int i=start;i<nums.length;i++){
            s.add(nums[i]);
            backtrack(i+1,nums,s,res);
            s.remove(s.size()-1);

        }
    }
}