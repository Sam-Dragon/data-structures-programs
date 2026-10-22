package stack.programs;

import java.util.Stack;

public class MinStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        if (mainStack.isEmpty()) {
            minStack.push(value);
            mainStack.push(value);
        } else {
            if (!minStack.isEmpty() && value < minStack.peek())
                minStack.push(value);
            mainStack.push(value);
        }
    }

    public Integer pop() {
        if (!minStack.isEmpty())
            minStack.pop();

        if (mainStack.isEmpty())
            return null;
        else
            return mainStack.pop();
    }

    public Integer top() {
        if (mainStack.isEmpty())
            return null;

        return mainStack.peek();
    }

    public Integer getMin() {
        if (minStack.isEmpty())
            return null;

        return minStack.peek();
    }

    static void main() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // Returns -3
        minStack.pop();
        System.out.println(minStack.top());      // Returns 0
        System.out.println(minStack.getMin());   // Returns -2
    }
}
