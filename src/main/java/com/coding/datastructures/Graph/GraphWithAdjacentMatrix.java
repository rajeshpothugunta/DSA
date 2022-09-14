package com.coding.datastructures.Graph;

public class GraphWithAdjacentMatrix {
    static int[][] a;
    int v;//vertex

    public GraphWithAdjacentMatrix(int v) {
        this.v = v;
        a=new int[v][v];
    }

    public static void addEdge(int src, int dest){
        a[src][dest]=1;
        a[dest][src]=1;
    }
    public static void main(String args[]) {
        int v = 4;
        GraphWithAdjacentMatrix graph = new GraphWithAdjacentMatrix(v);

        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);
        graph.addEdge(2, 1);
    }
}
