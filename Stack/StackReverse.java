package Stack;
import java.util.Scanner;
import java.util.Stack;
public class StackReverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            st.push(sc.nextInt());
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
       
        sc.close();
        //Collections.reverse(st);
        //System.out.println(st);
    }
}
