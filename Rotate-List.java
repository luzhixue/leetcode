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
    public ListNode rotateRight(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null) return null;
        ListNode curTail = head, newTail = head;
        int len = 1;
        while(curTail.next != null){
            curTail = curTail.next;
            ++len;
        }
        n = n % len;// in case n is larger than len
        int i = 1;
        while(i < len - n){
            newTail = newTail.next;
            ++i;
        }
        curTail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }
}
