/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
	private int getHeight(TreeNode root) {  
		if (root == null) return 0;  
		int depL = getHeight(root.left);  
		int depR = getHeight(root.right);  
		if (depL < 0 || depR < 0 || Math.abs(depL - depR) > 1) return -1;  
		else return Math.max(depL, depR) + 1;  
	}  
	public boolean isBalanced(TreeNode root) {  
		return (getHeight(root) >= 0);  
	}  


//..............The following Solution has repeated computations.........................

public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null) return true;
        if(Math.abs(height(root.left)-height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode node){
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left+1,right+1);
    }
}
