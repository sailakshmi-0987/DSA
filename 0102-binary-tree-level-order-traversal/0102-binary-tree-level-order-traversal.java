/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        result(root,0,ans);
        return ans;
    }
    public static void result(TreeNode node,int level,List<List<Integer>> ans){
        if(node==null){
            return;
        }
        if(ans.size()<=level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        result(node.left,level+1,ans);
        result(node.right,level+1,ans);
    }
}