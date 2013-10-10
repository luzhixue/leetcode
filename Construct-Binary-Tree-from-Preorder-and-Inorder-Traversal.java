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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return rootOfTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }

    private TreeNode rootOfTree(int[] preorder, int startPreIdx, int endPreIdx, int[] inorder, int startInIdx, int endInIdx){
        int len = endInIdx - startInIdx + 1;
        if(len <= 0) return null;
        int rootIdx = startInIdx;
        while(inorder[rootIdx] != preorder[startPreIdx]){
            ++rootIdx;
        }
        TreeNode root = new TreeNode(preorder[startPreIdx]);
        root.left = rootOfTree(preorder, startPreIdx+1, startPreIdx+1+(rootIdx-1-startInIdx), inorder, startInIdx, rootIdx-1);
        root.right = rootOfTree(preorder, endPreIdx-(endInIdx-rootIdx-1), endPreIdx, inorder, rootIdx+1, endInIdx);
        return root;
    }
}
