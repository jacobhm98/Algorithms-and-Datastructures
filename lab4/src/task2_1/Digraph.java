package task2_1;
import task1.Bag;
import task2.*;

/*
a class that creates a directed graph. Entirely the same as the undirected graph, except when an edge is added,
the relationship is not transitive. This can be seen in the addEdge method.
 */

public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private int Edges [][];
    private int edgeCount = 1;

    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
        this.Edges = new int[V][V];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
    public int[][] Edges(){
        return Edges;
    }

    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);  //an edge from v to w is not the same as an edge from w to v, not transitive
        Edges[v][w] = edgeCount;
        edgeCount++;

    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }



}

