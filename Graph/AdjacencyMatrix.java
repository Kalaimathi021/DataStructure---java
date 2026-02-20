import java.util.Scanner;

public class AdjacencyMatrix{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();   
        int e = sc.nextInt();   

        int[][] arr = new int[v][v];


        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;   
        }

        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < v; j++) {
                if (arr[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}