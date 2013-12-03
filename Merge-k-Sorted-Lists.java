//comparator writing  new Comparator<Object>{int compare(Object a, Object b){return a.val-b.val;}}
//and methods:  add(Object o), remove(Object o), poll(), peek();


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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        if(lists.size() == 1) return lists.get(0);
        PriorityQueue<ListNode> myHeap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null)   //need this check!...........................
                myHeap.add(lists.get(i));
        }
        ListNode root = new ListNode(0), cur = root;
        while(myHeap.size() != 0){
            cur.next = myHeap.poll();
            //myHeap.remove(0);
            cur = cur.next;
            if(cur.next != null){
                myHeap.add(cur.next);
            }
            cur.next = null;
        }
        return root.next;
    }
}
