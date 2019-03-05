package task2_3;
import task2_1.*;
public class TopologicalSort {
/*
test client for a topological sort
 */
    public static void main(String[] args){
        Digraph G = new Digraph(13);    //amount of vertices in given graph
        G.addEdge(0, 2);            //this is what happens when you're trying to beat a deadline and it's 2am
        G.addEdge(0,2);             //it's not pretty but it works :))))))
        G.addEdge(2,5);
        G.addEdge(3,0);
        G.addEdge(4,2);
        G.addEdge(6,5);
        G.addEdge(7,6);
        G.addEdge(8,7);
        G.addEdge(9,10);
        G.addEdge(9,11);
        G.addEdge(9,12);
        G.addEdge(11,12);

        DepthFirstSearchOrder search = new DepthFirstSearchOrder(G);    //run the ting
        System.out.println("Topological Sort of given Graph is: ");
        System.out.println(search.topologicalSort());   //printalize the topologically sortificated end product
    }
}
