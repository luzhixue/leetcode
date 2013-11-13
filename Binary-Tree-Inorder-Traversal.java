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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(cur != null || !stack.isEmpty()){
            if(cur == null){//left child has been visited
                cur = stack.pop();
                list.add(cur.val);//visit
                cur = cur.right;
            } 
            else{//left child has not been visited
                if(cur.left != null){//has left child, push current node
                    stack.push(cur);
                    cur = cur.left;
                }
                else{//visit this, go to next
                    list.add(cur.val);
                    cur = cur.right;
                }
            }

        }
        return list;
    }
}
