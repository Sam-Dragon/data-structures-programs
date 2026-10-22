package stack.programs;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {


    private static String infixToPostfix(String input) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> symbols = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isAlphabetic(c))
                postfix.append(c);
            else
                symbols.push(c);
        }

        while (!symbols.isEmpty())
            postfix.append(symbols.pop());

        return postfix.toString();
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

        String postfix = infixToPostfix(infix);
        System.out.println("Is Parenthesis Balanced (" + infix + ") = " + postfix);
    }

}
