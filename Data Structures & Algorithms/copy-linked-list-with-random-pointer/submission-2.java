/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node dummy = new Node(0);
        Node prev = dummy, temp = head;

        while(temp != null){
            Node newNode = new Node(temp.val);
            prev.next = newNode;
            prev = newNode;
        
            hm.put(temp, newNode);
            temp = temp.next;
        }

        Node newHead = dummy.next;
        Node temp1 = head;
        Node temp2 = newHead;
        while(temp1 != null){
            if(temp1.random == null){
                temp2.random = null;
            }else{
                temp2.random = hm.get(temp1.random);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        } 

        return newHead;

    }
}
