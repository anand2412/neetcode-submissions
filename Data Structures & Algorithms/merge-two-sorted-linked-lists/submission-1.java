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
        ListNode dummy = new ListNode(-1); // Dummy node to simplify edge cases
    ListNode current = dummy; // Current node pointing to the merged list

    // Traverse both lists until one of them is null
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) { // List1's value is smaller or equal
            current.next = list1;
            list1 = list1.next;
        } else { // List2's value is smaller
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next; // Move the current pointer
    }

    // If any nodes remain in either list, attach them to the merged list
    if (list1 != null) {
        current.next = list1;
    } else {
        current.next = list2;
    }

    return dummy.next;
    }
}