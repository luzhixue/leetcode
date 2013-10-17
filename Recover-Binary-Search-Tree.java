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
    TreeNode node1 = null, node2 = null, pre = null;
    public void recoverTree(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null) return;
        node1 = null;
        node2 = null;
        locateNodes(root, null);
        swap();
    }
    //return the previos node, to compare with the current node
    private TreeNode locateNodes(TreeNode root, TreeNode pre){
        if(root == null) return pre;
        TreeNode leftPre = locateNodes(root.left, pre);
        if(leftPre != null && leftPre.val > root.val){//out of order
            if(node1 == null){//found the first node
                node1 = leftPre;
                node2 = root;
            }
            else{
                node2 = root;//found the second node
                return root;
            }
        }
        return locateNodes(root.right, root);
    }
    
    private void swap(){
        if(node1 == null || node2 == null) return;
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
    
}
