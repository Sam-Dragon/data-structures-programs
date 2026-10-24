package list.linked_list.programs;

import list.linked_list.node.Node;

import static list.linked_list.impl.MyLinkedList.head;

public class HasLoop {

    /*
     * Has Loop: use slow and fast ptr
     * slow : move by 1
     * fast : move by 2
     *
     * Loop = slow == fast
     */
    public boolean hasLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        return false;
    }
}
