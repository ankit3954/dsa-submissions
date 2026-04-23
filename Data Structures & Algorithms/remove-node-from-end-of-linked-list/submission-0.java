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
        ListNode temp = head;
        int size = 0;

        while(temp != null){
            temp = temp.next;
            size++;
        }

        int nodeToBeRemovedPosition = size - n + 1;
        ListNode prev = null, curr = head;

        int count = 1;
        while(count < nodeToBeRemovedPosition && curr != null){
            prev = curr;
            curr = curr.next;
            count++;
        }

        if(prev == null){
            return curr.next;
        }
        prev.next = curr.next;
        return head;
    }
}
