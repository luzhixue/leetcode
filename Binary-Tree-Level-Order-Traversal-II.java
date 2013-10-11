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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> curList = new ArrayList<Integer>();
        queue.offer(root);
        int levelNum = 0, totalNum = 1;
        while(queue.peek() != null){
            TreeNode node = queue.poll();
            ++levelNum;
            curList.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(levelNum == totalNum){
                list.add(0,curList);
                curList = new ArrayList<Integer>();
                totalNum = queue.size();
                levelNum = 0;
            }
        }
        return list;
    }
}
 
 
 
//using array, better to use a queue
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null) return list;
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        ArrayList<Integer> curList = new ArrayList<Integer>();
        nodeList.add(root);
        int levelCur = 0, levelEnd = 0;
        while(levelCur < nodeList.size()){
            TreeNode node = nodeList.get(levelCur);
            curList.add(node.val);
            if(node.left != null){
                nodeList.add(node.left);
            }
            if(node.right != null){
                nodeList.add(node.right);
            }
            if(levelCur == levelEnd){
                list.add(0,curList);
                curList = new ArrayList<Integer>();
                levelEnd = nodeList.size()-1;
            }
            ++levelCur;
        }
        return list;
    }
}
