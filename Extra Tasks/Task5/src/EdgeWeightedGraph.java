/*
The following is a program which constructs an undirected graph with a specified amount
of vertices. Connections between vertices can be added using the addEdge method.
 */


public class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator"); //for the toString method.

    private final int V;//number of vertices in graph
    private int E;      //number of edges
    private Bag<Edge>[] adj;     //a vector of an ADT used to store each edge connected to the target vertex

    public EdgeWeightedGraph(int V, int E) {   //a constructor which initializes the above private variables and data structures
        this.V = V;
        this.E = E;
        adj = (Bag<Edge>[]) new Bag[V]; //an array of bags that are associated by their index to their given nodes
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }


    public void addEdge(Edge e) { //The adjacency bag is updated for both vertices of the edge
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;    //edgecount is incremented


    }

    public Iterable<Edge> adj(int v) {   //returns the stack of given vertex
        return adj[v];
    } //return the adjacency list of the given vertex


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}


