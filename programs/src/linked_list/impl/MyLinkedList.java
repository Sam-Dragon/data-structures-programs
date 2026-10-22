package linked_list.impl;

import linked_list.node.Node;

public class MyLinkedList {

    public static Node head, tail;
    public static int length;

    public MyLinkedList() {
    }

    public MyLinkedList(int value) {
        Node node = new Node(value);
        head = tail = node;
        length = 1;
    }

    /*
     * Append : Adds the value to the last
     * - It is used in queue implementation
     */
    public void append(int value) {
        Node node = new Node(value);

        if (head == null)
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }

        length++;
    }

    /*
     * Prepend : Adds the value to the first
     * - It is used in stack implementation
     */
    public void prepend(int value) {
        Node node = new Node(value);

        if (head == null)
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }

        length++;
    }

    /*
     * insert : add the node to specified position
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        } else {
            Node node = new Node(value);

            Node prev = get(index - 1);
            Node curr = prev.next;

            prev.next = node;
            node.next = curr;

            length++;
            return true;
        }
    }

    /*
     * removeFirst : removes the value to the list
     * It is used in both stack and queue
     */
    public Node removeFirst() {
        if (length == 0)
            return null;

        Node temp = head;
        if (length == 1)
            head = tail = null;
        else
            head = head.next;

        length--;

        temp.next = null;
        return temp;
    }

    /*
     * removeLast : removes the value to the list
     */
    public Node removeLast() {
        if (length == 0)
            return null;

        Node temp = head;
        if (length == 1)
            head = tail = null;
        else {
            while (temp != null && temp.next != tail)
                temp = temp.next;

            tail = temp;
        }

        length--;

        temp.next = null;
        return temp;
    }

    /*
     * remove : remove the node to specified position
     */
    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;

        if (index == 0)
            return removeFirst();
        else if (index == length - 1)
            return removeLast();
        else {
            Node prev = get(index - 1);
            Node curr = prev.next;

            prev.next = curr.next;
            length--;

            curr.next = null;
            return curr;
        }
    }

    /*
     * get : fetches the node at the specified index
     */
    public Node get(int index) {
        if (length == 0 || index < 0 || index >= length)
            return null;

        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp;
    }

    /*
     * set : update the value of the node at the specified index
     */
    public boolean set(int index, int value) {
        Node node = get(index);
        if (node == null)
            return false;

        node.value = value;
        return true;
    }
}
