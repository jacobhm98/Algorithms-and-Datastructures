/*
A simple test program for dijkstras algorithm. It initializes an undirected edge weighted graph based off an input
file and runs an instance of Dijkstra's shortest path algorithm.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SPNYC {

    public static void main(String[] args)throws FileNotFoundException {
        if (args[0] == "test") {
            File input = new File("C:\\Users\\jacob\\Documents\\KTH\\Algorithms and Data structures\\Task5\\NYC.txt");
            Scanner scan = new Scanner(input);
            int vertices = scan.nextInt();  //the total amount of vertices
            int edges = scan.nextInt();     //the total amount of directed edges
            edges = edges / 2;    //undirected edges
            EdgeWeightedGraph G = new EdgeWeightedGraph(vertices, edges);
            int v;
            int w;
            int weight;
            Edge e;
            boolean counter = true;
            while (scan.hasNext()) {
                v = scan.nextInt(); //reading in every line from the input file
                w = scan.nextInt();
                weight = scan.nextInt();
                if (counter) {  //inputting every other line into the graph
                    e = new Edge(v, w, weight);
                    G.addEdge(e);
                    counter = false;
                } else counter = true;

            }
            Dijkstra sp = new Dijkstra(G, 0);   //run a search from vertex 0
            if (sp.hasPathTo(4)) {
                System.out.println(sp.pathTo(4));
                System.out.println(sp.distTo(4));
            } else
                System.out.println("no path found");

        }
    }





}
