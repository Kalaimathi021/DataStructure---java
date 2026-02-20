import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();   
        int e = sc.nextInt();   

        List<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int des = sc.nextInt();

            list.get(src).add(des);
            list.get(des).add(src);   
        }


        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : list.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
