//BFS search
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
    public int minDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null) return 0;
        int depth = 1;
        ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>();
        curLevel.add(root);
        while(curLevel != null && curLevel.size() != 0){
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node : curLevel){
                if(node.left == null && node.right == null) return depth;//find a leaf
                if(node.left != null) nextLevel.add(node.left);
                if(node.right != null) nextLevel.add(node.right);
            }
            curLevel = nextLevel;
            ++depth;
        }
        return depth;
    }
}


//DFS
public class Solution {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return minD(root);
    }

    //this is wrong, because you need to judge if a node is leaf! consider {1,2}, this method will return 1
    /*public int minD(TreeNode node){
        if(node == null) return 0;  
        return Math.min(minD(node.left)+1,minD(node.right)+1);
    }*/
    
    public int minD(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null)
            return 1;
        if(node.left !=null){
            int leftDepth = minD(node.left);
            if(node.right != null)
                return Math.min(leftDepth+1, minD(node.right)+1);
            return leftDepth+1;
        }
        else{
            return minD(node.right)+1;
        }
    }
}
//BFS in general performs better. We can use Queue<TreeNode> queue = new LinkedList<TreeNode>(); to cliam a queue in java
//queue.peek  queue.offer(node)   queue.poll()   to test, add, delement element
//for DFS, we can improve by keeping a curDepth, and a curMinDepth, then prone the subtree if it is deeper than the known curMinDepth

//http://n00tc0d3r.blogspot.com/2013/04/minimum-depth-of-binary-tree.html
