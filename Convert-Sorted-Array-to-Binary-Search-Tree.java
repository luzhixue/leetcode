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
    public TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return rootOfBST(num, 0, num.length-1);
        
    }
   
    private TreeNode rootOfBST(int[] num, int startIdx, int endIdx){
        int len = endIdx-startIdx+1;
        if(len <= 0) return null;
        int rootIdx = startIdx + len/2;
        TreeNode root = new TreeNode(num[rootIdx]);
        root.left = rootOfBST(num, startIdx, rootIdx-1);
        root.right = rootOfBST(num, rootIdx+1, endIdx);
        return root;
    }
}
