package list.doubly_linked_list.programs;

import list.doubly_linked_list.node.Node;

import static list.doubly_linked_list.impl.MyDoublyLinkedList.*;


public class Reverse {

    /*
     * Use three pointers to solve it
     * Set first to null, second to head and third to next node
     */
    public void reverse() {
        if (length < 2)
            return;

        Node prev, curr = head;
        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;

            curr = curr.prev;
        }

        prev = head;
        head = tail;
        tail = prev;
    }
}
