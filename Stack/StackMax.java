package Stack;
import java.util.Stack;
import java.util.Scanner;
public class StackMax {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            st.push(sc.nextInt());
        }

        int max=st.peek();
        for(int i=0;i<size;i++){
            if(st.peek()>max){
                max=st.peek();

            }
            st.pop();
        }
        System.out.println(max);
        sc.close();
    }
}
