class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    public static void backtrack(int[] candidates,int target,int i,List<Integer> curr,List<List<Integer>> res){
        if(target ==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<1 || i==candidates.length){
            return;
        }
        curr.add(candidates[i]);
        backtrack(candidates,target-candidates[i],i,curr,res);
        curr.remove(curr.size()-1);

        backtrack(candidates,target,i+1,curr,res);
    }
}