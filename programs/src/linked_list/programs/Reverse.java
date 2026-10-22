package linked_list.programs;

import linked_list.node.Node;

import static linked_list.impl.MyLinkedList.*;

public class Reverse {

    /*
    * Use three pointers to solve it
    * Set first to null, second to head and third to next node
    */
    public void reverse() {
        if (length < 2)
            return;

        Node prev = null, curr = head;
        tail = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
}
