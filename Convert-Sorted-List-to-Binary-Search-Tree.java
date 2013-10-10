//find the middle node as the root, recurse left/right child
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return rootOfBST(head, lengthOfList(head));
    }
    
    private int lengthOfList(ListNode head){
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            ++len;
        }
        return len;
    }
    
    private TreeNode rootOfBST(ListNode head, int len){
        if(len <= 0) return null;
        int rootIdx = len/2, curIdx = 0;
        ListNode curNode = head;
        while(curIdx < rootIdx){
            ++curIdx;
            curNode = curNode.next;
        }
        TreeNode root = new TreeNode(curNode.val);
        root.left = rootOfBST(head, len/2);
        root.right = rootOfBST(curNode.next, len-len/2-1);
        return root;
    }
    
}
