/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextHead = slow.next;
        slow.next = null;
        head = sortList(head);
        nextHead = sortList(nextHead);//cannot simply call sortList(nextHead), need this assignment function!
        head = merge(head, nextHead);
        return head;
    }
    
    public ListNode merge(ListNode head, ListNode nextHead){
        if(head == null && nextHead == null) 
            return null;
        if(head == null)
            return nextHead;
        if(nextHead == null)
            return head;
        ListNode tmpHead = new ListNode(0);
        ListNode merged = tmpHead;
        while(head != null && nextHead != null){
            if(head.val < nextHead.val){
                merged.next = head;
                head = head.next;
                merged = merged.next;
                merged.next = null;
            }
            else{
                merged.next = nextHead;
                nextHead = nextHead.next;
                merged = merged.next;
                merged.next = null;
            }
        }
        if(head != null)
            merged.next = head;
        else if(nextHead != null)
            merged.next = nextHead;
        return tmpHead.next;
    }
    
}
