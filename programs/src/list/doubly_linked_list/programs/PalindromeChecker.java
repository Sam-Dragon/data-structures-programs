package list.doubly_linked_list.programs;

import list.doubly_linked_list.node.Node;

import static list.doubly_linked_list.impl.MyDoublyLinkedList.head;
import static list.doubly_linked_list.impl.MyDoublyLinkedList.tail;

public class PalindromeChecker {

    public boolean isPalindrome() {
        Node start = head, end = tail;

        while (start != null && end != null) {
            if (start.value != end.value)
                return false;

            start = start.next;
            end = end.prev;
        }

        return true;
    }
}
