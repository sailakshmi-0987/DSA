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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int currentlevel = 0;
        int resultlevel = 0;
        while(!q.isEmpty()){
            currentlevel++;
            int levelSum = 0;
            int nodecount = q.size();
            for(int i=0;i<nodecount;i++){
                TreeNode currentNode = q.pollFirst();
                levelSum+=currentNode.val;
                if(currentNode.left!=null){
                    q.offer(currentNode.left);
                }
                 if(currentNode.right!=null){
                    q.offer(currentNode.right);
                }
            }
            
                if(levelSum>maxSum){
                    maxSum = levelSum;
                    resultlevel = currentlevel;
                }
           
        }
        return resultlevel;
    }
}