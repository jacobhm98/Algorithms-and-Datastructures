public class Edge implements Comparable<Edge>{  //an abstraction for an edge between nodes
    private final int v, w;     //each edge contains two vertices
    private final double weight;    //each edge also has a weight

    public Edge(int v, int w, double weight){   //constructor
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){    //return one node from the edge
        return this.v;
    }
    public int other(int v){    //return the other node than the one given in argument
        if (v == this.v) return this.w;
        else return this.v;
    }
    public double weight(){
        return this.weight;
    }

    public int compareTo(Edge that){    //compare the weight of edge with another edge
        if (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return 1;
        else return 0;
    }
    public String toString(){   //to string method so it looks nice when printed :)
        return "Vertex 1 " + v + ", Vertex 2 " + w + " Weight " + weight;
    }
}