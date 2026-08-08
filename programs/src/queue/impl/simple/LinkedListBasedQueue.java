package queue.impl.simple;

import java.util.Scanner;

public class LinkedListBasedQueue {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node first, last;
    int size;

    public LinkedListBasedQueue() {
        first = last = null;
        size = 0;
    }

    public LinkedListBasedQueue(int element) {
        first = last = new Node(element);
        ++size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enqueue(int element) {
        // Create Node
        Node node = new Node(element);

        // Check if empty, new node is first node and set pointers
        if (isEmpty()) {
            first = last = node;
        } else {
            // Insert Rear
            last.next = node;
            last = node;
        }

        ++size;
        return true;
    }

    public Integer dequeue() {
        // If queue is empty
        if (isEmpty())
            return null;

        int data = first.data;
        first = first.next;

        // Reset Last to null, If first is null
        if (isEmpty())
            last = null;

        --size;
        return data;
    }

    public Integer peek() {
        // validation - queue overflow
        if (isEmpty())
            return null;

        // delete & decrement
        return first.data;
    }

    public void display() {
        Node temp = first;

        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }

        System.out.println();
    }

    static void main() {
        int choice;
        LinkedListBasedQueue queue = new LinkedListBasedQueue();

        while (true) {
            System.out.println();
            try {
                System.out.println("Please select the operation to perform");
                System.out.println("""
                        1: Enqueue
                        2: Dequeue
                        3. Peek
                        4. Size
                        5. Display
                        """);
                System.out.println("Enter your choice");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("<<< INSERT >>>");
                        System.out.println("Enter the element to insert");
                        int element = sc.nextInt();
                        boolean isInserted = queue.enqueue(element);
                        System.out.println("Element inserted successfully ? " + isInserted);
                        break;
                    case 2:
                        System.out.println("<<< DELETE >>>");
                        Integer deleted = queue.dequeue();
                        System.out.println("Element removed = " + deleted);
                        break;
                    case 3:
                        System.out.println("<<< TOP ELEMENT >>>");
                        Integer topOfStack = queue.peek();
                        System.out.println("Element on top of queue = " + topOfStack);
                        break;
                    case 4:
                        System.out.println("<<< TOTAL ELEMENTS >>>");
                        int size = queue.size();
                        System.out.println("Total Elements = " + size);
                        break;
                    case 5:
                        System.out.println("<<< CONTENT >>>");
                        queue.display();
                        break;
                    default:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Exception Occurred :: " + e.getMessage());
            }
        }
    }
}
