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


//It Can also be done with or without using a stack iteratively.
//see http://n00tc0d3r.blogspot.com/2013/03/flatten-binary-tree-to-linked-list-in.html

//Solution - Non-Recursion, No Stack
//We can also solve the problem even without a stack:
//Each time when we prune a right subtree, we use while-loop to find the right-most leaf of the current left subtree, 
//and append the subtree there.
 public void flatten(TreeNode root) {  
   TreeNode cur = root;  
   while (cur != null) {  
     if (cur.left != null) {  
       if (cur.right != null) { // if we need to prune a right subtree
         TreeNode next = cur.left;  
         while (next.right != null) next = next.right;  
         next.right = cur.right;  
       }
       cur.right = cur.left;  
       cur.left = null;  
     }  
     cur = cur.right;  
   }  
 }  
//We visit each node at most twice (one for flattening and maybe one for looking for rightmost leaf) and then for 
//each node, cut the right tree and append it to its rightmost node. Overall, we access each node constant time. 
//So the total running time is O(n) with O(1) space


