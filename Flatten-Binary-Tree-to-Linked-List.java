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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        flatTree(root);
    }
    
    private TreeNode flatTree(TreeNode node){//return the last node of the left subtree
        if(node.left == null && node.right == null){//leaf
            return node;
        }
        else{
            if(node.left != null){
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;//do not forget this line, otherwise, there is a endless recurssion
                TreeNode lastLeft = flatTree(node.right);
                if(tmp != null){
                    lastLeft.right = tmp;
                    TreeNode lastRight = flatTree(tmp);
                    return lastRight;
                }
                else{
                    return lastLeft;                    
                }
              }
            else{
                return flatTree(node.right);
            }
        }
    }
}








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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        root = flatTree(root);
    }
    
    private TreeNode flatTree(TreeNode node){//reurn the first node after flatten
        if(node.left == null && node.right == null){//leaf
            return node;
        }
        else{
            if(node.left != null){
                TreeNode tmp = node.right;
                node.right = flatTree(node.left);//traverse left child
                node.left = null;//do not forget this line !!!!!
                if(tmp !=null){
                    TreeNode pointer = node;
                    while(pointer.right !=null){
                        pointer = pointer.right;
                    }
                    pointer.right = flatTree(tmp);//trverse right child
                }
                return node;
            }
            else{
                node.right = flatTree(node.right);
                return node;
            }
        }
    }
}




