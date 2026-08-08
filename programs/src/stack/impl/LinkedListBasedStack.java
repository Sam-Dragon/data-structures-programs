package stack.impl;

import java.util.Scanner;

public class LinkedListBasedStack {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    int size;

    public LinkedListBasedStack() {
        head = null;
        size = 0;
    }

    public LinkedListBasedStack(int element) {
        head = new Node(element);
        ++size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(int element) {
        // Create Node
        Node node = new Node(element);

        // Check if empty, new node is first node and set pointers
        if (!isEmpty()) {
            // If not empty, set the new node to head
            node.next = head;
        }
        head = node;

        ++size;
        return true;
    }

    public Integer pop() {
        // If stack is empty
        if (isEmpty())
            return null;

        int data = head.data;
        head = head.next;

        --size;
        return data;
    }

    public Integer peek() {
        // validation - stack overflow
        if (isEmpty())
            return null;

        // delete & decrement
        return head.data;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }

        System.out.println();
    }

    static void main() {
        int choice;
        LinkedListBasedStack stack = new LinkedListBasedStack();

        while (true) {
            System.out.println();
            try {
                System.out.println("Please select the operation to perform");
                System.out.println("""
                        1: Push
                        2: Pop
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
                        boolean isInserted = stack.push(element);
                        System.out.println("Element inserted successfully ? " + isInserted);
                        break;
                    case 2:
                        System.out.println("<<< DELETE >>>");
                        Integer deleted = stack.pop();
                        System.out.println("Element removed = " + deleted);
                        break;
                    case 3:
                        System.out.println("<<< TOP ELEMENT >>>");
                        Integer topOfStack = stack.peek();
                        System.out.println("Element on top of stack = " + topOfStack);
                        break;
                    case 4:
                        System.out.println("<<< TOTAL ELEMENTS >>>");
                        int size = stack.size();
                        System.out.println("Total Elements = " + size);
                        break;
                    case 5:
                        System.out.println("<<< CONTENT >>>");
                        stack.display();
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
