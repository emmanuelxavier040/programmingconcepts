package graphs;

import java.util.ArrayList;

public class GraphRepresentation {


    static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer> > adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());

        addEdge(0,1,adj);
        addEdge(0,2,adj);
        addEdge(1,5,adj);
        addEdge(3,4,adj);
        addEdge(0,4,adj);

        printGraph(adj);
    }
}
