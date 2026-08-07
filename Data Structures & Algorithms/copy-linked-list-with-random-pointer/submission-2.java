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
        if(head == null) return null;

        // Interweave og and copy nodes 1->1'->2->2'
        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // random for copy will be next to OG random
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // go to next OG node
        }

        
        Node dummy = new Node(0);
        Node tail = dummy;
        curr = head;
        while(curr != null) {
            tail.next = curr.next;
            tail = tail.next;
            curr.next = tail.next;
            curr = curr.next;
        }

        return dummy.next;




    }
}
