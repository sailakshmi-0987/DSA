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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return result(p,q);
        
    }
    public boolean result(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }
        
        if(node1==null||node2==null){
            return false;
        }
        
        if(node1.val != node2.val){
           return false;
        }
        
        return result(node1.left,node2.left)&&result(node1.right,node2.right);
        
    }
}