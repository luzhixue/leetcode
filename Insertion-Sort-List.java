/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head;//this is the merged list, do not create a tmpHead as usual, which might change the order during sorting
        head = head.next;
        newHead.next = null;//need to set to null 
        while(head != null){
            ListNode cur = head;
            head = head.next;
            cur.next = null;
            newHead = insert(newHead, cur);
        }
        return newHead;
    }
    
    private ListNode insert(ListNode head, ListNode node){
        if(head == null && node == null) return null;
        if(head == null) return node;
        if(node == null) return head;
        ListNode pre = null, cur = head;
        while(cur != null && cur.val < node.val){
            pre = cur;
            cur = cur.next;
        }
        if(pre == null){
            node.next = cur;
            return node;
        }
        else{//insert before cur;
            pre.next = node;
            node.next = cur;
            return head;
        }
    }
}
