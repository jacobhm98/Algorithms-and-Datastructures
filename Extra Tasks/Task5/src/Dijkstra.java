public class Dijkstra {
    private Edge[] edgeTo;  //array of edges where index is associated by vertex, and the edge in the entry gives the edge used to reach vertex
    private double[] distTo;    //distance from source to each vertex
    private IndexMinPQ<Double> pq;

    public Dijkstra(EdgeWeightedGraph G, int s){    //Find shortest paths to all other nodes given one source node
        edgeTo = new Edge[G.V()];   //initialize data structures
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;   //set the distance to all nodes in graph as infinity before start of algorithm
        }
        distTo[s] = 0;  //set distance to source node to 0

        pq.insert(s, 0.0);
        while(!pq.isEmpty()){   //while the priority queue is not empty
            int v = pq.delMin();    //relax all edges of each vertex, building off of the vertex closest to source. When done, delete this vertex from pq.
            for(Edge e : G.adj(v)){ //for each edge in the adjacency list of v, relax them
                relax(e, v);
            }
        }

    }
    private void relax(Edge e, int v){
        int w;  //w is the node v leads to
        w = e.other(v);
        if(distTo[w] > distTo[v] + e.weight()){ //if the new distance to w given using the edge being checked is lower than the current distance
            distTo[w] = distTo[v] + e.weight(); //update the distTo array
            edgeTo[w] = e;  //set the way we reach node w as the current edge being relaxed
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);   //if the priority queue already contains the node, decrease distance to it
            else pq.insert(w, distTo[w]);   //if the pq doesnt contain the node, input it
        }
    }

    double distTo(int v){
    return distTo[v];
    }   //the distance to each node will be contained in the distTo array at conclusion of algorithm

    public boolean hasPathTo(int v){
        return (distTo(v) < Double.POSITIVE_INFINITY);
    }   //if the distance to a certain node is infinite, this node has not been touched by the algorithm

    public Iterable<Edge> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<Edge>();
        int w = v;
        int temp;
        for (Edge e = edgeTo[w]; e != null; e = edgeTo[w]){ //using the edgeTo matrix, we follow a given node back to the source
            path.push(e);       //and push each node visited to a stack
            temp = e.other(w);
            w = temp;
        }
        return path;    //we return this stack, which will contain all the edges used to reach the given node
    }
}
