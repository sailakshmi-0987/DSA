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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        findAverage(root,ans);
        return ans;
    }
    public void findAverage(TreeNode node,List<Double> ans){
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(node);

       while(!q.isEmpty()){
        int level = q.size();
        double average = 0;
        for(int i=0;i<level;i++){
            TreeNode curr=q.poll();
            average+=curr.val;
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        average = average/level;
        ans.add(average);
       }
    }
}