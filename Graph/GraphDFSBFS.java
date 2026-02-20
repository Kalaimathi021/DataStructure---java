import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class GraphDFSBFS {

    ArrayList<ArrayList<Integer>> li = new ArrayList<>();

    void bfs(int start, int v) {

        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        vis[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");

            for (int val : li.get(temp)) {
                if (!vis[val]) {
                    vis[val] = true;
                    q.offer(val);
                }
            }
        }
    }

    void dfs(int start, boolean[] vis) {

        vis[start] = true;
        System.out.print(start + " ");

        for (int val : li.get(start)) {
            if (!vis[val]) {
                dfs(val, vis);
            }
        }
    }

     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        GraphDFSBFS g = new GraphDFSBFS();

        for (int i = 0; i < v; i++) {
            g.li.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            g.li.get(src).add(dest);
            g.li.get(dest).add(src); 
        }

        int start = sc.nextInt();

        System.out.println("BFS:");
        g.bfs(start, v);

        System.out.println("\nDFS:");
        boolean[] vis = new boolean[v];
        g.dfs(start, vis);

        sc.close();
    }
}
