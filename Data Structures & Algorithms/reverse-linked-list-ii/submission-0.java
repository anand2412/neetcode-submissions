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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prevLeft = dummy;
        ListNode curr = null;
        
        
        
        for(int i=0; i < left - 1; i++) {
        	prevLeft = prevLeft.next;
        }

        curr = prevLeft.next;
        ListNode prev = null;
        int count = 0;
        ListNode leftNode = curr;
        while(count < right - left + 1) {
        	ListNode next = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = next;
        	count++;
        }
        
     
        
        leftNode.next = curr;
        prevLeft.next = prev;
        return dummy.next;
    }
}