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
        int carry = 0, sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(l1 != null && l2 != null){
            sum = carry + l1.val + l2.val;
             ListNode newNode;
            if(sum > 9){
                carry = 1;
                newNode = new ListNode(sum % 10);
            }else{
                carry = 0;
                newNode = new ListNode(sum);
            }
            prev.next = newNode;
            prev = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            sum = carry + l1.val;
            ListNode newNode;
            if(sum > 9){
                carry = 1;
                newNode = new ListNode(sum % 10);
            }else{
                carry = 0;
                newNode = new ListNode(sum);
            }

            prev.next = newNode;
            prev = newNode;
            l1 = l1.next;
        }

        while(l2 != null){
            sum = carry + l2.val;
            ListNode newNode;
            if(sum > 9){
                carry = 1;
                newNode = new ListNode(sum % 10);
            }else{
                carry = 0;
                newNode = new ListNode(sum);
            }

            prev.next = newNode;
            prev = newNode;
            l2 = l2.next;
        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
        }


        return dummy.next;
    }
}
