public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = null, pre = null;
        while(!stack.isEmpty()){
            cur = stack.peek();//always look at the top element of the stack
            if((cur.left == null && cur.right == null) ||(pre != null && pre == cur.left) || (pre != null && pre == cur.right)){
                cur = stack.pop();
                ret.add(cur.val);
                pre = cur;
            }
            else{
                if(cur.right != null)
                    stack.push(cur.right);
                if(cur.left != null)
                    stack.push(cur.left);
            }
        }
        return ret;
    }
}
