import java.util.Scanner;
import java.util.PriorityQueue;
public class PriorityQueueMin {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        for(int i=0;i<a;i++){
            pq.offer(sc.nextInt());
        }
        for(int i=0;i<a;i++){
            System.out.println(pq.poll());;
        }



        sc.close();
    }
}
