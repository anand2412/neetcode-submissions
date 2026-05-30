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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode traverse = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;

            int sum = v1 + v2 + carry;
            int nodeValue = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(nodeValue);
            traverse.next = node;
            traverse = traverse.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int v1 = l1.val;
            int sum = v1 + carry;
            int nodeValue = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(nodeValue);
            traverse.next = node;
            traverse = traverse.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int v2 = l2.val;
            int sum = v2 + carry;
            int nodeValue = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(nodeValue);
            traverse.next = node;
            traverse = traverse.next;
            l2 = l2.next;
        }

        if(carry != 0) {
          ListNode node = new ListNode(carry);
          traverse.next = node;
        }

        return dummy.next;
    }
}
