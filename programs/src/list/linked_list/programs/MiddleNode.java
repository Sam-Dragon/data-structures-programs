package list.linked_list.programs;

import list.linked_list.node.Node;

import static list.linked_list.impl.MyLinkedList.head;

public class MiddleNode {

    /*
     * Middle Node: use slow and fast ptr
     * slow : move by 1
     * fast : move by 2
     */
    public Node findMiddleNode() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
