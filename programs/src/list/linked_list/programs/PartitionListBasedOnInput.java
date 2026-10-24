package list.linked_list.programs;

import list.linked_list.node.Node;

import static list.linked_list.impl.MyLinkedList.head;

public class PartitionListBasedOnInput {

    /*
     * Partition List: Use dummy pointers and assign the values
     */
    public void partitionList(int x) {
        Node belowHead = new Node(0), below = belowHead;
        Node aboveHead = new Node(0), above = aboveHead;

        Node temp = head;
        while (temp != null) {
            // below check
            Node node = new Node(temp.value);
            if (temp.value < x) {
                below.next = node;
                below = below.next;
            } else {
                above.next = node;
                above = above.next;
            }

            temp = temp.next;
        }

        if (belowHead.next == null)
            head = aboveHead.next;
        else {
            below.next = aboveHead.next;
            head = belowHead.next;
        }
    }
}
