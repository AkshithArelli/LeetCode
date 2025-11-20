Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
  
Example 2
Input: head = [1], n = 1
Output: []
  
Example 3:
Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

  Solution:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //T:O(n), S:O(1)

        //using dummy node helps in handling edge cases efficiently
        //1->2->null n=1    or  1->null n=1
        //with dummy nodes: -1->1->2->null   or -1->1->null
        //return dummy.next:  1->null            null

        //Create a dummy node before head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        //Move secondPtr n steps ahead
        for (int i=0; i<n; i++) {
            secondPtr = secondPtr.next;
        }

        //Move both now, until next of secondPtr is not null
        while (secondPtr.next != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        firstPtr.next = firstPtr.next.next;

        return dummy.next;
    }
}
