package task2_3;
import task2_1.*;
import task1.Stack;

/*
A class which runs a topological sort on a digraph and stores this sort in a stack.
 */

public class DepthFirstSearchOrder {    //data structures blah blah blah
    private Digraph G;
    private boolean[] marked;
    private Stack<Integer> reversePost;


    public DepthFirstSearchOrder(Digraph G) {   //initialize all that shit and run a search centered around each unmarked node, starting with node 0
        this.reversePost = new Stack();
        this.marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
        {
            if (!marked[v]){
                dfs(G, v);
            }
        }
    }


    private void dfs(Digraph G, int v){ //you know the deal
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w]){
                dfs(G, w);
            }
        }
        this.reversePost.push(v);   //push em in the way that we're finished with em. Resulting in a topological sort.
    }


    public Iterable<Integer> topologicalSort(){     //we wanna see what we're working with
        return reversePost;
    }


}
