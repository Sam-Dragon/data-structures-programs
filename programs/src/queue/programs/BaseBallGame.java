package queue.programs;

import java.util.Arrays;
import java.util.Stack;

public class BaseBallGame {

    public int calPoints(String[] operations) {
        int total = 0;

        // Considering if the operation is empty
        if (operations.length == 0)
            return total;

        Stack<String> stack = new Stack<>();
        for (String input : operations) {
            if (input.equals("+")) {
                if (stack.size() > 1) {
                    int next = Integer.parseInt(stack.pop());
                    String sum = String.valueOf(next + Integer.parseInt(stack.peek()));

                    stack.push(String.valueOf(next));
                    stack.push(sum);
                }
            } else if (input.equals("C") && !stack.isEmpty())
                // Clean up latest element
                stack.pop();
            else if (input.equals("D") && !stack.isEmpty())
                // Double the latest element
                stack.push(String.valueOf((Integer.parseInt(stack.peek()) * 2)));
            else
                stack.push(input);
        }

        while (!stack.isEmpty()) {
            total += Integer.parseInt(stack.pop());
        }

        return total;
    }

    static void main() {
        String[] ops = new String[]{"1", "2", "+", "C", "5", "D"};
        System.out.println(Arrays.toString(ops));

        int total = new BaseBallGame().calPoints(ops);
        System.out.println("Total = " + total);


        ops = new String[]{"5", "D", "+", "C"};
        System.out.println(Arrays.toString(ops));

        total = new BaseBallGame().calPoints(ops);
        System.out.println("Total = " + total);

        ops = new String[]{"5", "2", "C", "D", "+"};
        System.out.println(Arrays.toString(ops));

        total = new BaseBallGame().calPoints(ops);
        System.out.println("Total = " + total);
    }
}
