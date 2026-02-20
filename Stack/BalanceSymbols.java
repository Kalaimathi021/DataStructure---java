package Stack;
import java.util.Scanner;

public class BalanceSymbols {

    public static boolean isBalanced(String str) {

        char[] stack = new char[str.length()];
        int top = -1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;
            }


            else if (ch == ')' || ch == '}' || ch == ']') {


                if (top == -1) {
                    return false;
                }

                char popped = stack[top--];

                if ((ch == ')' && popped != '(') ||
                    (ch == '}' && popped != '{') ||
                    (ch == ']' && popped != '[')) {
                    return false;
                }
            }
        }

        return top == -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression:");
        String input = sc.nextLine();

        if (isBalanced(input)) {
            System.out.println("Symbols are Balanced");
        } else {
            System.out.println("Symbols are Not Balanced");
        }

        sc.close();
    }
}
