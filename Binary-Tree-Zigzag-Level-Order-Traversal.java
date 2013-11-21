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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        boolean lToR = true;
        while(!stack.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            Stack<TreeNode> nextStack = new Stack<TreeNode>();
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                level.add(node.val);
                if(lToR){//current lToR
                    if(node.left != null)   nextStack.push(node.left);
                    if(node.right != null)  nextStack.push(node.right);  
                }
                else{//current rToL
                    if(node.right != null) nextStack.push(node.right);
                    if(node.left != null) nextStack.push(node.left);
                }
            }
            list.add(level);
            stack = nextStack;
            lToR = !lToR;
        }
        return list;
        
    }
}
