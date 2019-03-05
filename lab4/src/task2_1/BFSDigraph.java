package task2_1;

/*
A test class for the digraph and breadth first search. Finds the shortest path between two vertices on an undirected graph.
 */
import task1.RedBlackBST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BFSDigraph {
    static RedBlackBST<String, Integer> ST = new RedBlackBST(); //Digraph created in the exact same way as the graph


    public static void main(String[] args) throws FileNotFoundException{
    Digraph G = createDigraph();
        BreadthFirstSearch search = new BreadthFirstSearch(G, 16);   //run breadth first search on a digraph centered around 16th node
        int w = 9;
        if (search.hasPathTo(w)) {
            System.out.println("There is a way: ");
            System.out.println(search.pathTo(w));      //print out the path to the 12th node
        }
        else System.out.println("there is no path");


    }


    public static Digraph createDigraph() throws FileNotFoundException {
        File input = new File("C:\\Users\\jacob\\Documents\\KTH\\Algorithms and Data structures\\lab4\\input.txt"); //setting the file containing information relevant to building the graph
        Scanner scanify = new Scanner(input);
        Scanner scanification = new Scanner(input);
        int nodeNr = 0;
        String key;


        while(scanify.hasNext()){
            key = scanify.next();
            if (ST.contains(key)){
            }
            else{
                ST.put(key, nodeNr);
                nodeNr++;
            }
        }
        Digraph G = new Digraph(nodeNr);
        while(scanification.hasNext()){
            key = scanification.next();
            G.addEdge(ST.get(key), ST.get(scanification.next()));
        }

        return G;
    }

}
