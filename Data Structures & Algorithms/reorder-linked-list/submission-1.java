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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) {
           return;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;  
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = second;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode firstH = head;
        ListNode secondH = prev;
        int i = 1;
        while(secondH != null) {
            ListNode temp1 = firstH.next;
            ListNode temp2 = secondH.next;
            firstH.next = secondH;
            secondH.next = temp1;

            firstH = temp1;
            secondH = temp2;
        }
    }
}
