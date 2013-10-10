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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return rootOfTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode rootOfTree(int[] inorder, int startInIdx, int endInIdx, int[] postorder, int startPostIdx, int endPostIdx){
        int len = endInIdx - startInIdx + 1;
        if(len <= 0) return null;
        int rootIdx = startInIdx;
        while(inorder[rootIdx] != postorder[endPostIdx]){
            ++rootIdx;
        }
        TreeNode root = new TreeNode(postorder[endPostIdx]);
        root.left = rootOfTree(inorder, startInIdx, rootIdx-1, postorder, startPostIdx, startPostIdx+(rootIdx-1-startInIdx));
        root.right = rootOfTree(inorder, rootIdx+1, endInIdx, postorder, endPostIdx-1-(endInIdx-rootIdx-1),endPostIdx-1);
        return root;
    }
    
}
