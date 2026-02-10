package Stack;
import java.util.Stack;
import java.util.Scanner;
public class StackMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack <Integer> stack=new Stack<>();
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            stack.push(sc.nextInt());
        }
        int min=stack.peek();
        for(int i=0;i<size;i++){
            if(stack.peek()<min){
                min=stack.peek();

            }
            stack.pop();
        }
        System.out.println(min);

        sc.close();

    }
}
