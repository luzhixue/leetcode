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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return null;
        //firstTail is the end of the first list
        //secondTail is node #m
        //finished point to the head of finished reversed list, will be node #n after reversal
        //cur is the node to be reversed
        ListNode firstTail = null, secondTail = null, finished = null, cur = null;
        if(m > 1){
            firstTail = head;
            int num = 1;
            while(num < m-1){
                firstTail = firstTail.next;
                ++num;
            }
        }
        
        cur = (m>1)?firstTail.next:head;
        secondTail = cur;
        int num = m;
        while(num <=n && cur != null){
            ListNode tmp = cur.next;//save next node to reverse
            cur.next = finished;//reverse
            finished = cur;
            cur = tmp;//move to next
            ++num;
        }
        if(firstTail != null)
            firstTail.next = finished;
        secondTail.next = cur;
        
        return (m>1)?head:finished;

    }
}
