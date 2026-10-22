package stack.programs;

import java.util.Arrays;
import java.util.Stack;

public class CompressArray {

    static void main() {
        System.out.println("Input Array");
        int[] arr = {8, 4, 2, 2, 2, 4};
        System.out.println(Arrays.toString(arr));

        Stack<Integer> compressedArr = compressedArray(arr);
        System.out.println(Arrays.toString(compressedArr.toArray()));
    }

    private static Stack<Integer> compressedArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();


        // Validation
        if (arr.length < 2)
            return stack;

        // Processing
        for (int value : arr) {
            int val = value;
            while (!stack.isEmpty() && stack.peek() == val) {
                val += stack.pop();
            }
            stack.push(val);
        }


        return stack;
    }
}
