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
    class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode node,int index){
            this.node = node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int minIndex = queue.peek().index;
            int size = queue.size();
            int first =0,last=0;
            for(int i=0;i<size;i++){
                Pair curr = queue.poll();
                TreeNode node = curr.node;
                int index = curr.index-minIndex;

                if(i==0)first = index;
                if(i==size-1)last=index;

                if(node.left!=null){
                    queue.offer(new Pair(node.left,2*index));
                }
                 if(node.right!=null){
                    queue.offer(new Pair(node.right,2*index+1));
                }
            }
            maxWidth = Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}