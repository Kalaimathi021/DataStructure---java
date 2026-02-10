import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;
public class PriorityQueueMax {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        for(int i=0;i<a;i++){
            pq.offer(sc.nextInt());
        }
        for(int i=0;i<a;i++){
            System.out.print(pq.poll()+" ");
        }
       

        sc.close();
    }
}
