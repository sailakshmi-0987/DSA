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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight=true;
        while(!queue.isEmpty()){
            int level = queue.size();
            LinkedList<Integer> curr = new LinkedList<>();
            for(int i=0;i<level;i++){
                TreeNode node = queue.poll();
                if(leftToRight){
                    curr.addLast(node.val);
                }
                else{
                    curr.addFirst(node.val);
                }

                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            ans.add(curr);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}