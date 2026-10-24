package list.doubly_linked_list.programs;

import list.doubly_linked_list.node.Node;

import static list.linked_list.impl.MyLinkedList.head;

public class SwapPairs {

    public void swapPairs() {
        if (head == null || head.next == null)
            return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node previous = dummy;
        Node first = head;

        while (first != null && first.next != null) {
            Node second = first.next;

            // Perform the swap
            previous.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers
            previous = first;
            first = first.next;
        }

        head = dummy.next;
    }
}
