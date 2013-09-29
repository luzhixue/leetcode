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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return false;
        return pathSumEqual(root, sum, 0);
    }
    
    private boolean pathSumEqual(TreeNode node, int sum, int curSum){
        if(node.left == null && node.right == null){
            return (sum == curSum+node.val);
        }
        else{
            boolean leftChildEqual = false, rightChildEqual = false;
            if(node.left != null){
                leftChildEqual = pathSumEqual(node.left, sum, curSum+node.val);
            }
            if(leftChildEqual) return true;
            if(node.right != null){
                rightChildEqual = pathSumEqual(node.right, sum, curSum+node.val);
            }
            return rightChildEqual;
        }
    }
}
