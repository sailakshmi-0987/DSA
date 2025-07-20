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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        result(root,ans,"");
        return ans;
    }
    public void result(TreeNode node,List<String> ans,String str){
        if(node==null){
            return;
        }
        str+=node.val;
        if(node.left==null && node.right==null){
            ans.add(str);
            return;
        }
        str+="->";
        result(node.left,ans,str);
        result(node.right,ans,str);
        
    }
}