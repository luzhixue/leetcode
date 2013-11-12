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
    public ListNode partition(ListNode head, int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null) return null;
        ListNode smallHead = new ListNode(Integer.MIN_VALUE), largeHead = new ListNode(Integer.MAX_VALUE);
        ListNode curSmall = smallHead, curLarge = largeHead, cur = head;
        while(cur != null){
            if(cur.val < x){
                curSmall.next = cur;
                curSmall = curSmall.next;
                cur = cur.next;
            }
            else{
                curLarge.next = cur;
                curLarge = curLarge.next;
                cur = cur.next;
            }
        }
        curSmall.next = largeHead.next;
        curLarge.next = null;
        return smallHead.next;
    }
}
