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

    ListNode leftPointer;
    public boolean isPalindrome(ListNode head) {

        leftPointer = head;
        return helper(head);

    }
    public boolean helper(ListNode right) {
        if(right == null) return true;

        boolean res = helper(right.next);
        if(!res){
            return false;
        }

        boolean isMatched = leftPointer.val == right.val;
        leftPointer = leftPointer.next;

        return isMatched;
    }

}