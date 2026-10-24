package list.doubly_linked_list.programs;

import list.doubly_linked_list.node.Node;

import static list.doubly_linked_list.impl.MyDoublyLinkedList.head;

public class PartitionListBasedOnInput {

    /*
     * Partition List: Use dummy pointers and assign the values
     */
    public void partitionList(int x) {
        Node lessHead = new Node(0), less = lessHead;
        Node greaterHead = new Node(0), greater = greaterHead;

        Node temp = head;
        while (temp != null) {
            if (temp.value < x) {
                Node node = new Node(temp.value);
                less.next = node;
                node.prev = less;

                less = less.next;
            } else {
                Node node = new Node(temp.value);
                greater.next = node;
                node.prev = greater;

                greater = greater.next;
            }

            temp = temp.next;
        }

        greater.next = null;
        less.next = greaterHead.next;

        if (greaterHead.next != null)
            greaterHead.next.prev = less;

        head = lessHead.next;
        if (head != null)
            head.prev = null;
    }
}
