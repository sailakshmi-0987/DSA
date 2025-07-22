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
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1;i++){
            int diff = Math.abs(arr.get(i)-arr.get(i+1));
            min = Math.min(min,diff);
        }
        return min;
    }
    public void inorder(TreeNode node,List<Integer> arr){
        if(node == null){
            return;
        }
        inorder(node.left,arr);
        arr.add(node.val);
        inorder(node.right,arr);
    }
}