package queue.impl.simple;

import java.util.Scanner;

public class ArrayBasedQueue {

    private final int SIZE = 5;
    int[] array = new int[SIZE];
    int front = 0, rear = -1;

    public int size() {
        return rear - front + 1;
    }

    public boolean isEmpty() {
        return front == 0 && rear == -1;
    }

    public boolean isFull() {
        return rear == SIZE - 1;
    }

    public boolean enqueue(int element) {
        if (front > rear) {
            front = 0;
            rear = -1;
        }

        // validation - queue overflow
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }

        // increment rear & insert
        array[++rear] = element;
        return true;
    }

    public int dequeue() {
        if (front > rear) {
            front = 0;
            rear = -1;
        }

        // validation - queue underflow
        if (isEmpty())
            throw new RuntimeException("Queue Underflow");

        // delete front & decrement
        return array[front++];
    }

    public int peek() {
        if (front > rear) {
            front = 0;
            rear = -1;
        }

        // validation - queue overflow
        if (isEmpty())
            throw new RuntimeException("Queue Underflow");

        // peek the top value
        return array[front];
    }

    public void display() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");

        for (int i = front; i <= rear; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    static void main() {
        int choice;
        ArrayBasedQueue queue = new ArrayBasedQueue();

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
