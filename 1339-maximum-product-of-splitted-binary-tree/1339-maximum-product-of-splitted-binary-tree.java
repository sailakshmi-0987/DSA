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
    private long maxProductValue;
    private long totalSum;
    public int maxProduct(TreeNode root) {
        final int MODULO = (int) 1e9 + 7;
        totalSum = calculateTotalSum(root);
        findMaxProduct(root);
        return (int) (maxProductValue % MODULO);
    }
    private long findMaxProduct(TreeNode root) { 
        if (root == null) {
            return 0;
        }
        long currentSubtreeSum = root.val + findMaxProduct(root.left) + findMaxProduct(root.right);
        if (currentSubtreeSum < totalSum) {
            long product = currentSubtreeSum * (totalSum - currentSubtreeSum);
            maxProductValue = Math.max(maxProductValue, product);
        }
      
        return currentSubtreeSum;
    }
    private long calculateTotalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + calculateTotalSum(root.left) + calculateTotalSum(root.right);
    }
}