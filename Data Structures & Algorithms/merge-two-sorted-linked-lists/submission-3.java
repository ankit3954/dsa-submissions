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
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 == null && list2 != null){
            return list2;
        }else if(list1 != null && list2 == null){
            return list1;
        }else if(list1.next == null && list2.next == null){
            if(list1.val > list2.val){
                list2.next = list1;
                list1.next = null;
                return list2;
            }else{
                list1.next = list2;
                list2.next = null;
                return list1;
            }
        }else{
            if(list1.val > list2.val){
                ListNode sortedLinkedListHead = mergeTwoLists(list1, list2.next);
                list2.next = sortedLinkedListHead;
                // list1.next = sortedLinkedListHead;
                return list2;
            }else{
                ListNode sortedLinkedListHead = mergeTwoLists(list1.next, list2);
                list1.next = sortedLinkedListHead;
                // list2.next = sortedLinkedListHead;
                return list1;
            }
        }
    }
}