
/*
A program which runs breadth first search on a given graph
 */
package task2;
import task1.Queue;
import task1.Graph;
import task1.Stack;

public class BreadthFirstSearch {
    private Graph G;
    private int v;
    private boolean[] marked;   //whether or not the node at index has been visited
    private int[] edgeTo;       //where the node was visited from


    public BreadthFirstSearch(Graph G, int v) { //initialize data structures and run breadth first search
        this.G = G;
        this.v = v;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        breadthFirstSearch();

    }

    private void breadthFirstSearch(){
        Queue<Integer> q = new Queue(); //create a queue which will be used for the search
        q.enqueue(this.v);  //enqueue the node which the search starts with
        marked[this.v] = true;  //set it to visited
        while(!q.isEmpty())     //keep search going until queue is exhausted and each node visited
        {
            int x = q.dequeue();    //dequeu the first vertex on queue
            for (int w : G.adj(x)){ //add each of this vertex's neighbours
                if (!marked[w]){    //if this neighbour is unvisited, add it to the queue
                    q.enqueue(w);
                    marked[w] = true;   //indicate that it has been visited
                    edgeTo[w] = x;      //specify from where
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        int edgeCount = 0;  //total weight of path is stored here
        int[][] Edges = G.Edges();      //matrix of weight of each edge
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack();
        for (int x = v; x != this.v; x = edgeTo[x]){    //iterate through the path to given vertex following it back using information of where it was visited from
            path.push(x);
            edgeCount += Edges[x][edgeTo[x]];   //update current edge weight
        }
        path.push(this.v);
        path.push(edgeCount);   //add total edge count to top of stack
        return path;
    }
}
