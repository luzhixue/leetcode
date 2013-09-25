/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBST(TreeNode root, int min, int max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        boolean leftBST = isBST(root.left, min, root.val);
        if(!leftBST) return false;
        boolean rightBST = isBST(root.right, root.val, max);
        return rightBST;
        //return (leftBST && rightBST);
    }
 
}
