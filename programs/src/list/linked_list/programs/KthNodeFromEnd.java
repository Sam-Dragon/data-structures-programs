package list.linked_list.programs;

import list.linked_list.node.Node;

import static list.linked_list.impl.MyLinkedList.head;

public class KthNodeFromEnd {

    /*
     * Kth node from end: use slow and fast ptr
     * fast : move by provided index, if missing return
     *
     * Then,
     * move slow and fast by each by 1 position
     */
    public Node findKthFromEnd(int index) {
        Node slow = head, fast = head;

        for (int i = 0; i < index; i++) {
            if (fast == null)
                return null;

            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
