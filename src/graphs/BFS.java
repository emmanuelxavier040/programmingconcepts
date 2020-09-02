package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

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

        public void BFS(int s) {
            boolean visited[] = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);

            while(queue.size() != 0) {
                s = queue.poll();
                System.out.println(s);
                Iterator<Integer> i = adj.get(s).listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

    }

    /*
                 0
                /\
               /  \
              1----2
             /      \
            /        \
           3          4

     */

    public static void main(String args[]) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.BFS(0);
    }
}
