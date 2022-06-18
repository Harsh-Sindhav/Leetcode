             this.bst = bst;
         }
     }
    
    
    
    isBst helper(TreeNode root){
    
        if(root == null){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean bst = true;
            return new isBst(max,min,bst);
        }
        
        isBst left = helper(root.left);
        isBst right = helper(root.right);
        
        int max = Math.max(root.val, Math.max(right.max,left.max));
        int min = Math.min(root.val, Math.min(right.min,left.min));
        boolean bst = true;
        if(left.max >= root.val)  bst =false;
        if(right.min <= root.val) bst = false;
        if(!left.bst) bst = false;
        if(!right.bst) bst = false;
        isBst ans = new isBst(max,min,bst); 
        return ans;
    }
    
    
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        // return helper(root).bst;
     
    return isBST3(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
   
      boolean isBST3(TreeNode root,long minRange,long maxRange) {
         if(root == null) return true;
    
         if(root.val < minRange || root.val > maxRange) return false;
        
         boolean isLeftWithinRange = isBST3(root.left, (long)minRange, (long)root.val-1);
         boolean isRightWithinRange = isBST3(root.right, (long)root.val+1, (long)maxRange);
         return isLeftWithinRange && isRightWithinRange;
         
     }
}
