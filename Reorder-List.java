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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null)//if odd, first list is longer
            slow = slow.next;
        ListNode sndHead = slow.next;
        slow.next = null;
        sndHead = reverseList(sndHead);
        interleave(head, sndHead);        
    }
    
    private ListNode interleave(ListNode first, ListNode second){
        if(first == null && second == null) return null;
        if(first == null) return second;
        if(second == null) return first;
        ListNode tmpHead = new ListNode(0), cur = tmpHead, curF = first, curS = second;
        while(curF != null && curS != null){
            cur.next = curF;
            curF = curF.next;
            cur = cur.next;
            cur.next = curS;
            curS = curS.next;
            cur = cur.next;
        }
        if(curF != null)
            cur.next = curF;
        return tmpHead.next;
    }
    
    private ListNode reverseList(ListNode head){
        //ListNode tmp = new ListNode(0);
        if(head == null || head.next == null) return head;
        ListNode finished = null, cur = head, next = cur.next;
        while(cur != null){
            next = cur.next;
            cur.next = finished;
            finished = cur;
            cur = next;
        }
        return finished;
    }
}
