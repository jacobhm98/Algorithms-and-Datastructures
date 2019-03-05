/*
The following is a program which constructs a undirected graph with a specified amount
of vertices. Connections between vertices can be added using the addEdge method. The edges are weighted
in order of creation, meaning that the first edge added has weight 1, the second weight 2, and so-on.
 */


package task1;
import java.util.NoSuchElementException;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator"); //for the toString method.

    private final int V;    //number of vertices in graph
    private int E;      //number of edges total
    private Bag<Integer>[] adj;     //a vector of an ADT used to store each vertex's neighbour.
    private int Edges [][];     //a v by v array which keeps the weight of each edge in 2 locations, v by w and w by v
    private int edgeCount = 1;  //the value assigned to each edge as it's created

    public Graph(int V) {   //a constructor which initializes the above private variables and data structures
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
    public int[][] Edges(){     //returns the matrix where weight of edge is stored
        return Edges;
    }

    public void addEdge(int v, int w) { //the bag containing the list of adjacent vertices is updated for both v and w, the edgeCount matrix is updated with current edge weight
        E++;
        adj[v].add(w);
        adj[w].add(v);
        Edges[v][w] = edgeCount;
        Edges[w][v] = edgeCount;
        edgeCount++;

    }

    public Iterable<Integer> adj(int v) {   //returns the stack of given vertex
        return adj[v];
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

