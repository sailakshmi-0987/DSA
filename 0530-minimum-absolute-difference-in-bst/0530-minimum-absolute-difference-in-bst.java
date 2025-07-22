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
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<ans.size()-1;i++){
            int diff = Math.abs(ans.get(i)-ans.get(i+1));
            min =Math.min(min,diff);
        }
        return min;
    }
    public void inorder(TreeNode node,List<Integer> ans){
        if(node==null){
            return;
        }
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);
    }
}