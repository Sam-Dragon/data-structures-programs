package stack.programs;

import java.util.Scanner;
import java.util.Stack;

public class ReverseTheString {

    public static String reverse(String input) {
        Stack<Character> stack = new Stack<>();

        for (char character : input.toCharArray())
            stack.push(character);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }

    static void main() {
        String input = "";

        try {
            System.out.println("Enter the input String");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            System.out.println("Input = " + input);
        } catch (Exception e) {
            System.out.println("Exception :: " + e.getMessage());
        }

        if (input.isBlank()) {
            System.out.println("Please provide valid input");
            return;
        }

        String reversed = reverse(input);
        System.out.println("Reverse(" + input + ") = " + reversed);
    }
}
