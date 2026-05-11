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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head.next;
        while((fast != null && fast.next != null) && slow != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null){
            if(slow.val == slow.next.val){
                slow = slow.next;
            }else{
                return false;
            }
        }

        ListNode reverseHead = reverseList(slow.next);
        ListNode temp = head;
        while(reverseHead != null){
            if(temp.val != reverseHead.val){
                return false;
            }

            temp = temp.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        ListNode tail = head.next;
        tail.next = head;
        head.next = null;

        return newHead;
    }
}