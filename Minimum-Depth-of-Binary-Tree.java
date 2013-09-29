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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return minD(root);
    }

    //this is wrong, because you need to judge if a node is leaf! consider {1,2}, this method will return 1
    /*public int minD(TreeNode node){
        if(node == null) return 0;  
        return Math.min(minD(node.left)+1,minD(node.right)+1);
    }*/
    
    public int minD(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null)
            return 1;
        if(node.left !=null){
            int leftDepth = minD(node.left);
            if(node.right != null)
                return Math.min(leftDepth+1, minD(node.right)+1);
            return leftDepth+1;
        }
        else{
            return minD(node.right)+1;
        }
    }
}
