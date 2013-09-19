/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode first = root;//the first node in current level
        while(first != null){
            TreeLinkNode cur = first;
            while(cur != null){
                if(cur.left != null) cur.left.next = cur.right;
                if(cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            first = first.left;
        }
    }
}



//The following Recursion Solution requires O(n) space, since n-level recursion usually takes at least O(n) space for stack 
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        populate(root);
    }
    private void populate(TreeLinkNode node){
        if(node == null) return;
        TreeLinkNode left = node.left, right = node.right;
        while(left != null && right != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        populate(node.left);
        populate(node.right);
    }
}
