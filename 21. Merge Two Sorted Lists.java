You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.


Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.


  
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //T: O(n), S: O(1)
        ListNode returnNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = returnNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                headNode.next = list1; //here we attach linkedlist
                list1 = list1.next; //here we are moving the pointer forward, so
                //only one node is now assigned to headNode.next
            } else {
                headNode.next = list2; 
                list2 = list2.next;
            }
            headNode = headNode.next;
        }

        if (list1 != null) {
            headNode.next = list1; //here as we are not moving forward
            //entire linkedlist is attached now
        }
        if (list2 != null) {
            headNode.next = list2;
        }

        return returnNode.next;
    }
}
