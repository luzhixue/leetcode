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
    ArrayList<ArrayList<Integer>> list;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        list = new ArrayList<ArrayList<Integer>>();
        if(root == null) return list;
        allPaths(root, sum, 0, new ArrayList<Integer>());
        return list;
    }
    
    private void allPaths(TreeNode node, int sum, int curSum, ArrayList<Integer> curList){
        if(node.left == null && node.right == null){//leaf
            if(curSum + node.val == sum){
                curList.add(node.val);
                list.add(curList);
            }
        }
        else{
            if(node.left !=null){
                ArrayList<Integer> leftList = (ArrayList<Integer>)curList.clone();
                leftList.add(node.val);
                allPaths(node.left, sum, curSum+node.val, leftList);
            }
            if(node.right !=null){
                ArrayList<Integer> rightList = (ArrayList<Integer>)curList.clone();
                rightList.add(node.val);
                allPaths(node.right, sum, curSum+node.val, rightList);
            }
        }
    }
}
