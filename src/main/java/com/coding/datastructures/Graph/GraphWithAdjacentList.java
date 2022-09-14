package com.coding.datastructures.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphWithAdjacentList {
    static ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
    int v;

    public GraphWithAdjacentList(int v) {
        this.v = v;
        //add empty lists for all vertexes
        for(int i = 0; i<v; i++) {
            a.add(new ArrayList<Integer>());
        }
    }

    public static void addEdge(int src, int dest){
        a.get(src).add(dest);
        a.get(dest).add(src);
    }

    //dfs traversal
    public static void dfs(int src, boolean vis[]){
        //mark the vertex visited
        vis[src]= true;
        System.out.print(src+" ");
        for (Integer neighbour:a.get(src)){
            if(!vis[neighbour])
                dfs(neighbour,vis);
        }
    }
    //bfs traversal
    public static void bfs(int src, boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src]=true;
        while (!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur+" ");
            for(Integer neighbour : a.get(cur)){
                if(!vis[neighbour]){
                    q.add(neighbour);
                    vis[neighbour]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 4;
        GraphWithAdjacentList graph = new GraphWithAdjacentList(v);

        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);
        graph.addEdge(2, 1);

        boolean vis[] = new boolean[v];
        //dfs
        //dfs(0,vis);
        bfs(0,vis);

    }


}
