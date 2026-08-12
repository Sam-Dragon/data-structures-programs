package queue.impl.simple;

import java.util.Scanner;

public class ArrayBasedQueueSinglePointer {

    private final int SIZE = 5;
    int[] array = new int[SIZE];
    int top = -1;

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == SIZE - 1;
    }

    public boolean enqueue(int element) {
        // validation - queue overflow
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }

        // increment top & insert
        array[++top] = element;
        return true;
    }

    public int dequeue() {
        // validation - queue underflow
        if (isEmpty())
            throw new RuntimeException("Queue Underflow");

        int value = array[0];

        for (int i = 0; i < top; i++) {
            array[i] = array[i + 1];
        }
        array[top--] = 0;
        // delete front & decrement
        return value;
    }

    public int peek() {
        // validation - queue overflow
        if (isEmpty())
            throw new RuntimeException("Queue Underflow");

        // peek the top value
        return array[0];
    }

    public void display() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");

        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    static void main() {
        int choice;
        ArrayBasedQueueSinglePointer queue = new ArrayBasedQueueSinglePointer();

        while (true) {
            System.out.println();
            try {
                System.out.println("Please select the operation to perform");
                System.out.println("""
                        1: Enqueue
                        2: dequeue
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
                        int deleted = queue.dequeue();
                        System.out.println("Element removed = " + deleted);
                        break;
                    case 3:
                        System.out.println("<<< TOP ELEMENT >>>");
                        int topOfQueue = queue.peek();
                        System.out.println("Element on top of queue = " + topOfQueue);
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
