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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans  = new ArrayList<>();
        result(root,ans);
        return ans;
    }
    public void result(TreeNode node,List<Integer> ans){
        if(node==null){
            return;
        }
        result(node.left,ans);
        ans.add(node.val);
        result(node.right,ans);
    }
}