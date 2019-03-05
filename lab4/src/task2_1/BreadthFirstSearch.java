package task2_1;

/*
Breadth first search functions entirely in the same way as with an undirected graph. Difference is it accepts a digraph.
 */
import task1.Graph;
import task1.Queue;
import task1.Stack;

public class BreadthFirstSearch {
    private Digraph G;
    private int v;
    private boolean[] marked;
    private int[] edgeTo;


    public BreadthFirstSearch(Digraph G, int v) {
        this.G = G;
        this.v = v;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        breadthFirstSearch();

    }

    private void breadthFirstSearch(){
        Queue<Integer> q = new Queue();
        q.enqueue(this.v);
        marked[this.v] = true;
        while(!q.isEmpty())
        {
            int x = q.dequeue();
            for (int w : G.adj(x)){
                if (!marked[w]){
                    q.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = x;
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack();
        for (int x = v; x != this.v; x = edgeTo[x]){
            path.push(x);
        }
        path.push(this.v);
        return path;
    }
}
