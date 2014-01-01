public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                ret.add(cur.val);
                if(cur.right != null)
                    stack.push(cur.right);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
            }
        }
        return ret;
    }
}
