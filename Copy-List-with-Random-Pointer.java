//Implementing the second method as noted below:
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null) return null;
        //copy to make a 2N list:   1-->2-->3  :  1-->1-->2-->2-->3-->3
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        //copy the random
        cur = head;
        while(cur != null){
            if(cur.random == null) //need to check cur.random not null before calling cur.random.next
                cur.next.random = null;
            else
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //fix the list
        cur = head;
        RandomListNode newCur = cur.next, newHead = newCur;
        while(cur != null){
            cur.next = cur.next.next;
            if(newCur.next != null) //need to check newCur.next not null before calling newCur.next.next
                newCur.next = newCur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}



/*

Method 1 (Uses O(n) extra space)
This method stores the next and arbitrary mappings (of original list) in an array first, then modifies the original Linked List (to create copy), creates a copy. And finally restores the original list.

1) Create all nodes in copy linked list using next pointers.
3) Store the node and its next pointer mappings of original linked list.
3) Change next pointer of all nodes in original linked list to point to the corresponding node in copy linked list.



Method 2 (Uses Constant Extra Space)
Thanks to Saravanan Mani for providing this solution. This solution works using constant space.
1) Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N afte the Nth node
2) Now copy the arbitrary link in this fashion

     original->next->arbitrary = original->arbitrary->next;  //TRAVERSE TWO NODES
This works because original->next is nothing but copy of original and Original->arbitrary->next is nothing but copy of arbitrary.
3) Now restore the original and copy linked lists in this fashion in a single loop.

     original->next = original->next->next;
     copy->next = copy->next->next;
4) Make sure that last element of original->next is NULL.

Time Complexity: O(n)
Auxiliary Space: O(1)

*/
