package list.doubly_linked_list.impl;

import list.doubly_linked_list.node.Node;

public class MyDoublyLinkedList {

    public static Node head, tail;
    public static int length;

    public MyDoublyLinkedList() {
    }

    public MyDoublyLinkedList(int value) {
        Node node = new Node(value);
        head = tail = node;
        length = 1;
    }

    /*
     * Append : Adds the value to the last
     */
    public void append(int value) {
        Node node = new Node(value);

        if (length == 0)
            head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        length++;
    }

    /*
     * Prepend : Adds the value to the first
     */
    public void prepend(int value) {
        Node node = new Node(value);

        if (length == 0)
            head = tail = node;
        else {
            node.next = head;
            head.prev = node;
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
        } else if (index == length) {
            append(value);
        } else {
            Node node = new Node(value);

            Node prev = get(index - 1);
            Node curr = prev.next;

            prev.next = node;
            node.prev = prev;

            node.next = curr;
            curr.prev = node;

            length++;
        }

        return true;
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
        else {
            head = head.next;
            head.prev = null;
        }

        length--;

        temp.prev = null;
        temp.next = null;
        return temp;
    }

    /*
     * removeLast : removes the value to the list
     */
    public Node removeLast() {
        if (length == 0)
            return null;

        Node temp = tail;
        if (length == 1)
            head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }

        length--;

        temp.prev = null;
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
            curr.next.prev = prev;

            length--;

            curr.prev = null;
            curr.next = null;

            return curr;
        }
    }

    /*
     * get : fetches the node at the specified index
     */
    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;

        int mid = length / 2;
        if (index < mid) {
            Node temp = head;
            for (int i = 0; i < index; i++)
                temp = temp.next;
            return temp;
        } else {
            Node temp = tail;
            for (int i = length - 1; i > index; i--)
                temp = temp.prev;
            return temp;
        }
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
