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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);  
        dummy.next = head;  
        ListNode cur = dummy;  
        while (cur.next != null && cur.next.next != null) {  
            ListNode temp = cur.next;
            cur.next = cur.next.next;  
            cur = cur.next;
            temp.next = cur.next;
            cur.next = temp; 
            cur = cur.next;
        }
       return dummy.next;  
    }
}

//a recursive solution would work, but not constant space
