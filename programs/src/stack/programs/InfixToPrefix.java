package stack.programs;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {


    private static String infixToPostfix(String input) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> symbols = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isAlphabetic(c))
                prefix.append(c);
            else
                symbols.push(c);
        }

        while (!symbols.isEmpty())
            prefix.insert(0, symbols.pop());

        return prefix.toString();
    }

    static void main() {
        String infix = "";

        try {
            System.out.println("Enter the infix String");
            Scanner sc = new Scanner(System.in);
            infix = sc.nextLine();
            System.out.println("Input = " + infix);
        } catch (Exception e) {
            System.out.println("Exception :: " + e.getMessage());
        }

        if (infix.isBlank()) {
            System.out.println("Please provide valid infix expression");
            return;
        }

        String prefix = infixToPostfix(infix);
        System.out.println("Is Parenthesis Balanced (" + infix + ") = " + prefix);
    }

}
