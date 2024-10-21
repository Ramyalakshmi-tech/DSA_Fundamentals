package org.example;

import java.util.HashSet;

 class GraphImplementationUsingSet {
    HashSet<Edge> edgeSet;
    public GraphImplementationUsingSet(){
        edgeSet=new HashSet<>();

    }
      class Edge {
          int src;
          int dest;

          public Edge(int src, int dest) {
              this.src = src;
              this.dest = dest;
          }
      }
public void addEdge(int src,int dest){
             edgeSet.add(new Edge(src,dest));
}
public void removeEdge(int src,int dest){
             edgeSet.remove(new Edge(src,dest));
}
public void printSet(){
        for(Edge edj:edgeSet){
            System.out.println();
            System.out.print(edj.src+" "+edj.dest);
        }
}
         public static void main(String[] args) {
             GraphImplementationUsingSet setImpl = new GraphImplementationUsingSet();
             setImpl.addEdge(0,1);
             setImpl.addEdge(1, 2);
             setImpl.addEdge(2, 3);
             setImpl.printSet();
            setImpl.removeEdge(0,1);
            setImpl.printSet();
         }
     }


