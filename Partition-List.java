//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//You should preserve the original relative order of the nodes in each of the two partitions. 
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5. 

//Solution: create a small list and a large list, use a cur pointer to go through the original list, and add the node to
//either small or large list. Finally merge those two lists.

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
