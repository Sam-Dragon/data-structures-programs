package stack.programs;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {

    private static boolean isBalancedParentheses(String input) {
        Stack<Character> stack = new Stack<>();

        for (char character : input.toCharArray()) {
            if (stack.isEmpty())
                stack.push(character);
            else {
                if ((stack.peek() == '(' && character == ')'))
                    stack.pop();
                else
                    stack.push(character);
            }
        }

        return stack.empty();
    }

    private static boolean isBalancedParenthesesV2(String input) {
        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> symbolsMap = new HashMap<>();
        symbolsMap.put('(', ')');
        symbolsMap.put('[', ']');
        symbolsMap.put('{', '}');

        for (char character : input.toCharArray()) {
            if (stack.isEmpty())
                stack.push(character);
            else {
                if (symbolsMap.get(stack.peek()) == character)
                    stack.pop();
                else
                    stack.push(character);

            }
        }

        return stack.empty();
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

        boolean isBalanced = isBalancedParentheses(input);
        System.out.println("Is Parenthesis Balanced (" + input + ") = " + isBalanced);

        isBalanced = isBalancedParenthesesV2(input);
        System.out.println("Is Parenthesis Balanced (" + input + ") = " + isBalanced);
    }

}
