//use two pointers of (n) steps away
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null) return null;
        ListNode first = head, second = head;
        for(int i = 0; i < n; i++)
            first = first.next;
        if(first == null){//n is the length of the list
            head = head.next;
            return head;
        }
        while(first.next != null){//move to the last node, then second.next is the one to remove
            first = first.next;
            second = second.next;
        }
        //first = second.next;
        second.next = second.next.next;
        return head;
    }
}
