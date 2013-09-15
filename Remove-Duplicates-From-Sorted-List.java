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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode first = head, second = null;
        while(first != null){
            second = first.next;
            while(second != null && second.val == first.val){
                second = second.next;
            }
            first.next = second;
            first = second;
        }
        return head;
    }
}
