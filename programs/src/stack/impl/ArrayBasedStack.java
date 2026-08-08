package stack.impl;

import java.util.Scanner;

public class ArrayBasedStack {

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

    public boolean push(int element) {
        // validation - stack overflow
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }

        // increment & insert
        array[++top] = element;
        return true;
    }

    public int pop() {
        // validation - stack overflow
        if (isEmpty())
            throw new RuntimeException("Stack Underflow");

        // delete & decrement
        return array[top--];
    }

    public int peek() {
        // validation - stack overflow
        if (isEmpty())
            throw new RuntimeException("Stack Underflow");

        // delete & decrement
        return array[top];
    }

    public void display() {
        if (isEmpty())
            throw new RuntimeException("Stack Empty");

        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    static void main() {
        int choice;
        ArrayBasedStack stack = new ArrayBasedStack();

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
                        int deleted = stack.pop();
                        System.out.println("Element removed = " + deleted);
                        break;
                    case 3:
                        System.out.println("<<< TOP ELEMENT >>>");
                        int topOfStack = stack.peek();
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
