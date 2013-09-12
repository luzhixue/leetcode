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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        total = 0;
        if(root == null) return total;
        sum(root, 0);
        return total;
    }
    
    private void sum(TreeNode node, int curSum){
        if(node.left == null && node.right == null){
            total = total + curSum*10 + node.val;
        }
        else{
            curSum = curSum*10 + node.val;
            if(node.left != null)
                sum(node.left, curSum);
            if(node.right != null)
                sum(node.right, curSum);
        }
    }
}
