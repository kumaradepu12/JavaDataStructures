
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sys3022
 */
public class DepthFirstSearch {
    private static List<Integer> friends[];
    private static Stack<Integer> stack = new Stack<>();
    private static boolean[] visited;

    public static void main(String[] a) {
    Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        friends = new LinkedList[n];
        visited= new boolean[n];
        for (int i = 0; i < n; i++) {
            friends[i] = new LinkedList();
        }
        for (int i = 0; i < e; i++) {
            int s = in.nextInt();
            int v = in.nextInt();
            friends[s].add(v);
            friends[v].add(s);
        }
        int source = in.nextInt();
        int search=in.nextInt();
        
        visited[source] = true;
        stack.push(source);
        depthFirstSearch(search);
}

    private static void depthFirstSearch(int srh) {
        if(stack.isEmpty())
            return;
        else {
            int node=stack.pop();
            System.out.print(node+" ");
            if(srh==node)
                System.exit(0);
               visited[node]=true;
            Iterator<Integer> it=friends[node].iterator();
            while(it.hasNext()){
                int nd=it.next();
                if(!visited[nd]){
                    stack.push(nd);
                    depthFirstSearch(srh);
                }
                
            }
            
        }
    }
}
