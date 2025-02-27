package Graph;


import java.util.*;

public class Dfs {
    public static void main(String[] args) {
        // Number of vertices
        int vertices = 5;

        // Adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

        // Initialize each list inside the adjacency list
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);

        // Perform BFS starting from node 0
        DfsOfGraph(vertices, adj);
    }

    // Function to add an edge to the adjacency list
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

        adj.get(u).add(v);
        adj.get(v).add(u); // For an undirected graph, add both u -> v and v -> u
    }

    public static void DfsOfGraph(int vertices,ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[vertices];
        visited[0]=true;
        System.out.println("0"+" ");
        Helper(vertices,adj,visited,0);
    }
    public static void Helper(int vertices,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int k){
            ArrayList<Integer> list=adj.get(k);
            for(int i=0;i<list.size();i++){
                int val=list.get(i);
                if(!visited[val]){
                    visited[val]=true;
                    System.out.println(val+" ");
                    Helper(vertices,adj,visited,val);
                }
            }
        }
    }

