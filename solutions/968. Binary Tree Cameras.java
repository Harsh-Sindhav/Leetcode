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
    
    // -1 you need a camera, 0 you have a camera, 1 you are covered
    
    int count;
    public int minCameraCover(TreeNode root) {
        count = 0;
        int x = minCameraCover_(root); 
        if(x == -1) {
       count++;
     }
    return count;
    }
    public int minCameraCover_(TreeNode root) {
        if(root == null) return 1;
        
        int lans = minCameraCover_(root.left);
        int rans = minCameraCover_(root.right);
        
        if(lans == -1 || rans == -1){
            count++;
            return 0;
        }
        
        if(lans == 0 || rans == 0){
            return 1;
        }
        
        return -1;
        
    }
}
