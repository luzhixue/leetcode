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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(l1 == null && l2 == null) return null;
        ListNode curL1 = l1, curL2 = l2, newList = new ListNode(0), curNew = newList;
        while(curL1 != null && curL2 != null){
            if(curL1.val <= curL2.val){
                curNew.next = curL1;
                curNew = curL1;
                curL1 = curL1.next;
            }
            else{
                curNew.next = curL2;
                curNew = curL2;
                curL2 = curL2.next;
            }
        }
        if(curL1 != null){
            curNew.next = curL1;
        }
        else{
            curNew.next = curL2;
        }
        return newList.next;
    }
}
