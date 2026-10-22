package stack.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class CompressArrayByK {

    static void main() {
        System.out.println("Input Array");
        int[] arr = {1, 9, 9, 3, 3, 3, 4};
        System.out.println(Arrays.toString(arr));

        System.out.println("Enter the Count Value");
        int k = 0;
        try {
            Scanner sc = new Scanner(System.in);
            k = sc.nextInt();
            System.out.println("K Value = " + k);
        } catch (Exception e) {
            System.out.println("Exception");
        }

        int[] compressedArr = compressedArray(arr, k);
        System.out.println(Arrays.toString(compressedArr));
    }

    private static int[] compressedArray(int[] arr, int k) {
        int[] compressedByk = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // Validation
        if (arr.length < 2 || k <= 1)
            return arr;

        // Processing
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
            if (map.getOrDefault(value, 0) == k) {
                int val = stack.pop() + stack.pop() + value;
                while (map.getOrDefault(val, 0) == k - 1) {
                    val += stack.pop() + stack.pop();
                }
                map.put(val, map.getOrDefault(val, 0) + 1);
                stack.push(val);
            } else {
                stack.push(value);
            }
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            compressedByk[i] = stack.pop();
        }

        return compressedByk;
    }
}
