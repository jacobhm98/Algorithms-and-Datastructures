package task1;
import java.io.*;
import java.util.Scanner;
import task2.*;

/*
Test program for both the depth first search and the breadth first search. It also creates an undirected graph given
a list of vertices.
 */

public class InputGraph {
    static RedBlackBST<String, Integer> ST = new RedBlackBST(); //a symbol table used to transfer string name of nodes to int values


    public static void main(String[] args) throws FileNotFoundException {
        Graph G = createGraph();    //create the graph from a specific input source

        String testnode = "MS"; //test value of node in symbol table
        System.out.print("The value of " + testnode + " is ");
        System.out.println(ST.get(testnode));

        DepthFirstSearch zerch = new DepthFirstSearch(G, 0);    //run a depth first search on the graph centered around first node
        int w = 12;  //vertice to be searched to
        if(zerch.hasPathTo(w)){
            System.out.println("There is a path to node " + w);  //check if there is a path to it and print path
            System.out.println("The dfs path to node " + w + " is");
            System.out.println(zerch.pathTo(w));
        }
        else
            System.out.println("there is no path");



        BreadthFirstSearch search = new BreadthFirstSearch(G, 0);   //run a breadth first search
        if(search.hasPathTo(w)){    //check if there is a path
            System.out.println("BFS verified");
            System.out.println("The path to " + w +" is:");
            System.out.println(search.pathTo(w));
            System.out.println("First number is total weight of path");
        }
        else
            System.out.println("I said no");

    }

    public static Graph createGraph() throws FileNotFoundException{
        File input = new File("C:\\Users\\jacob\\Documents\\KTH\\Algorithms and Data structures\\lab4\\input.txt"); //setting the file containing information relevant to building the graph
        Scanner scanify = new Scanner(input);       //create two scanner objects as we need to go over the text file twice
        Scanner scanification = new Scanner(input);
        int nodeNr = 0;
        String key;


        while(scanify.hasNext()){      //while the first scanner is not empty, input every new node into the symbol tree
            key = scanify.next();       //assign an ascending integer value to these nodes, starting at 0
            if (ST.contains(key)){
            }
            else{
                ST.put(key, nodeNr);
                nodeNr++;
            }
        }
        Graph G = new Graph(nodeNr);    //create a graph of correct size and add the edges necessary
        while(scanification.hasNext()){
            key = scanification.next();
            G.addEdge(ST.get(key), ST.get(scanification.next()));
        }

        return G;       //return the wanted graph
    }

}
