/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class Pair{
        int dia;
        int height;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        return helper(root).dia;
    }
    
    Pair helper(TreeNode root){
        if(root == null){
            Pair ans = new Pair();
            ans.dia = 0;
            ans.height = 0;
            return ans;
        }
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        Pair ans = new Pair();
        ans.height = 1 + Math.max(left.height,right.height);
        ans.dia = Math.max(left.dia,Math.max(right.dia,left.height+right.height));
            return ans;
    }
    
    int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left,right);
    }
    
}
