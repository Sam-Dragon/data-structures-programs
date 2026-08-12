package stack.programs;

import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    public void enqueue(int value) {
        if (stack1.isEmpty())
            stack1.push(value);
        else {
            // Move all elements of stack1 to stack2
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

            // Add the element to stack 1
            stack1.push(value);

            // Move back the elements of stack2 to stack1
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
        }
    }

    public Integer dequeue() {
        if (stack1.isEmpty())
            return null;

        return stack1.pop();
    }

    public Integer peek() {
        if (stack1.isEmpty())
            return null;

        return stack1.peek();
    }

    public void display() {
        for (int i = stack1.size() - 1; i >= 0; i--) {
            System.out.print(stack1.get(i) + ", ");
        }
        System.out.println();
    }

    static void main() {
        QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks();
        queueUsingTwoStacks.enqueue(10);
        queueUsingTwoStacks.enqueue(20);
        queueUsingTwoStacks.enqueue(30);

        queueUsingTwoStacks.display();
        System.out.println(queueUsingTwoStacks.peek());
        int removed = queueUsingTwoStacks.dequeue();
        System.out.println(removed);

        queueUsingTwoStacks.display();
        System.out.println(queueUsingTwoStacks.peek());
    }
}
