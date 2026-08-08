package stack.programs;

import java.util.Stack;

public class SortStack {

    static void main() {
        System.out.println("Input Stack");
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println(stack);

        System.out.println("Sorted Stack");
        sortedArray(stack);
        System.out.println(stack);
    }

    private static void sortedArray(Stack<Integer> mainStack) {
        if (mainStack.size() < 2)
            return;

        Stack<Integer> tempStack = new Stack<>();
        while (!mainStack.isEmpty()) {
            // take the top element of main stack for comparison
            int top = mainStack.pop();

            if (tempStack.isEmpty())
                tempStack.push(top);
            else {
                while (!tempStack.isEmpty() && tempStack.peek() > top)
                    mainStack.push(tempStack.pop());

                tempStack.push(top);
            }
        }

        while (!tempStack.isEmpty())
            mainStack.push(tempStack.pop());
    }
}
