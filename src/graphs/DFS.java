package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DFS {

    public static class Graph {

        private int V;
        private ArrayList<ArrayList<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for(int i=0; i<V; i++)
                adj.add(new ArrayList<>());
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        public void DFS(int s) {
            boolean visited[] = new boolean[V];
            Stack<Integer> stack = new Stack<>();

            visited[s] = true;
            stack.push(s);

            while(stack.size() != 0) {
                s = stack.pop();
                System.out.println(s);
                Iterator<Integer> i = adj.get(s).listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        stack.push(n);
                    }
                }
            }
        }

    }

    /*
            0-- 1 --4 --5
            |     /
            |   /
            | /
            2 ---- 3
     */

    public static void main(String args[]) {
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(2,3);
        graph.DFS(0);
    }
}
