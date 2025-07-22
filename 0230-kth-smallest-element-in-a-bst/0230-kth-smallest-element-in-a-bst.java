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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        inorder(root,pq);
        for(int i=1;i<k;i++){
            if(k!=i){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public void inorder(TreeNode node,PriorityQueue<Integer> pq){
        if(node == null){
            return;
        }
        inorder(node.left,pq);
        pq.offer(node.val);
        inorder(node.right,pq);
    }
}