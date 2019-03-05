package task1;
/*
A program which runs a deapth first search on a directed graph.
 */

public class DepthFirstSearch {
    private Graph G;    //the graph to be searched
    private int v;      //the vertex to be searched from
    private boolean[] marked;   //a vector specifying whether or not the vertex at index has been visited
    private int[] edgeTo;       //a vector containing the vertex where index was accessed from


    public DepthFirstSearch(Graph G, int v){    //initializing data structures and prompting the search with given vertex
        this.G = G;
        this.v = v;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        dfs(G, v);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;   //set current vertex as visited (since we're visiting it now)
        for (int w : G.adj(v)){ //for each neighbour of v, check if it's visited. If it is, end call.
            if (!marked[w]){
                dfs(G, w);      //if not run search from neighbour
                edgeTo[w] = v;  //specify that we got to neighbour node from current node
            }
        }
    }

    public boolean hasPathTo(int w){
        return marked[w];
    }   //if the node has been visited, there is a path to it

    public Iterable<Integer> pathTo(int v){     //check what the path to given vertice is from node prompting search by iterating through
        if (!hasPathTo(v)) return null;         //the edgeTo matrix, which keeps information stored on how each node was accessed.
        Stack<Integer> path = new Stack();
        for (int x = v; x != this.v; x = edgeTo[x]){
            path.push(x);
        }
        path.push(this.v);
        return path;            //store and return the path iterated through
    }


}
