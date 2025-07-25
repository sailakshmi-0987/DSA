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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int[] index={0};
        return tree(preorder,inorder,0,preorder.length-1,map,index);
    }
    public TreeNode tree(int[] preorder,int[] inorder,int left,int right,Map<Integer,Integer> map,int[] index){
        if(left>right){
            return null;
        }
        int current = preorder[index[0]];
        index[0]++;
        TreeNode node = new TreeNode(current);
        if(left==right){
            return node;
        }
        int inorderIndex = map.get(current);
        node.left=tree(preorder,inorder,left,inorderIndex-1,map,index);
        node.right=tree(preorder,inorder,inorderIndex+1,right,map,index);
        return node;
    }
}