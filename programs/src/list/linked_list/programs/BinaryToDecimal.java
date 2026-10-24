package list.linked_list.programs;

import list.linked_list.node.Node;

import static list.linked_list.impl.MyLinkedList.head;

public class BinaryToDecimal {

    /*
    * Binary to Decimal
    * - multiply the value with 2 and add the current value
    */
    public int binaryToDecimal() {
        Node temp = head;

        int decimal = 0;
        while (temp != null) {
            decimal = decimal * 2 + temp.value;
            temp = temp.next;
        }

        return decimal;
    }
}
