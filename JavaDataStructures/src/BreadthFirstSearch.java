
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {

    private static List<Integer> friends[];
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] a) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        friends = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            friends[i] = new LinkedList();
        }
        for (int i = 0; i < e; i++) {
            int s = in.nextInt();
            int v = in.nextInt();
            friends[s].add(v);
            friends[v].add(s);
        }
        int source=in.nextInt();
        int search = in.nextInt();
        boolean[] visited = new boolean[n];
        visited[source] = true;
        q.add(source);
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            if (node == search) {
                break;
            }
            visited[node] = true;
            Iterator<Integer> it = friends[node].iterator();
            while (it.hasNext()) {
                int nd = it.next();
//                System.out.print("here " + nd + " ");
                if (!visited[nd]) {
                    q.add(nd);

                }
            }
            System.out.println("Queue :"+q);
        }

    }

}
