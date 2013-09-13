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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //find the maximum path starts at each node when doing DFS, and update the global maximum
        if (root == null) return 0;
        maxSum = Integer.MIN_VALUE;//need this in the function, since it is called multiple times for different testcases
        maxVal(root);
        return maxSum;
    }
    
    private int maxVal(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = maxVal(node.left);
        int rightSum = maxVal(node.right);
        //three paths start at node
        int path1 = leftSum + node.val;
        int path2 = rightSum + node.val;
        int path3 = node.val;
        //the maximum path goes through node: path1, path2, path3 or combine together
        int maxPath = Math.max(Math.max(path1,path2),path3);
        maxPath = (path1+path2-node.val > maxPath)?path1+path2-node.val:maxPath;
        maxSum = Math.max(maxSum, maxPath);
        //the maximum single path (not combined) is returned to parents
        return Math.max(Math.max(path1, path2), path3);
    }
}
