package stack.programs;

import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

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
        if(stack1.isEmpty())
            return null;

        return stack1.pop();
    }
}
