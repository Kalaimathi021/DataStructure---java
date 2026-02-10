package Stack;

import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfix {

    static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);


            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); 
            }

            else {
                while (!stack.isEmpty() &&
                        precedence(ch) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        System.out.println("Postfix expression: " + infixToPostfix(infix));
        
        sc.close();
    }
}

