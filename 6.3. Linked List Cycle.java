Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

  
Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

  
Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?


  Solution:

  /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        //concept:
        //lets say rabbit and tortoise running in a round track with different speeds, at some given point of time they both gonna meet. We will use the same logic here as well
        //T:O(n) , S:O(1)
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (slowPointer != null && fastPointer != null 
                    && fastPointer.next != null) {
                        
                        slowPointer = slowPointer.next;
                        fastPointer = fastPointer.next.next;

                        if (slowPointer == fastPointer) {
                            return true;
                        }
                    }
                    return false;

        //T:O(n) , S:O(n)
        // HashSet<ListNode> visited = new HashSet<>();
        // ListNode current = head;
        // while (current != null) {
        //     if (visited.contains(current)) {
        //         return true;
        //     }
        //     visited.add(current);
        //     current = current.next;
        // }
        // return false;
    }
}
