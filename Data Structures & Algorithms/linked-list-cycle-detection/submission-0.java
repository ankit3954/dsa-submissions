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
    public boolean hasCycle(ListNode head) {

        ListNode temp = head;
        while(temp != null){
            if(temp.val == -1111){
                return true;
            }

            temp.val = -1111;
            temp = temp.next;
        }

        return false;
    }
}
