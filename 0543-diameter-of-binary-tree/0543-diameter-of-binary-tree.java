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
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        calculateDiameterAndHeight(root);
        return maxDiameter;
    }
    private int calculateDiameterAndHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = calculateDiameterAndHeight(node.left);
        int rightHeight = calculateDiameterAndHeight(node.right);

        int diameter = leftHeight+rightHeight;
        maxDiameter = Math.max(diameter,maxDiameter);

        return 1+Math.max(leftHeight,rightHeight);

    }
}