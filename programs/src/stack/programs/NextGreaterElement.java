package stack.programs;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    static void main() {
        System.out.println("Input Array");
        int[] array = {4, 5, 2, 25, 7, 8};
        System.out.println(Arrays.toString(array));

        System.out.println("Output Array 1");
        int[] result = nextGreaterElement(Arrays.copyOf(array, array.length));
        System.out.println(Arrays.toString(result));
    }

    private static int[] nextGreaterElement(int[] array) {
        // validation
        if (array.length < 2)
            return array;

        int[] res = new int[array.length];
        // set all to -1
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        // Step 1: Find the next highest element in array & push to stack for comparison
        // Step 2: One you find the highest element, fill till the previous values

        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < array[i])
                stack.pop();

            // Only if peek is highest value
            if (!stack.isEmpty())
                res[i] = stack.peek();

            stack.push(array[i]);
        }

        return res;
    }
}
