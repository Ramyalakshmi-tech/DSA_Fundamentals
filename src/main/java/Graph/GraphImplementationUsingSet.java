package Graph;

import java.util.HashSet;
import java.util.Objects;

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
          @Override
          public boolean equals(Object o) {
              if (this == o) return true;
              if (o == null || getClass() != o.getClass()) return false;
              Edge edge = (Edge) o;
              return src == edge.src && dest == edge.dest;
          }

          @Override
          public int hashCode() {
              return Objects.hash(src, dest);
          }

          @Override
          public String toString() {
              return "(" + src + " -> " + dest + ")";
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


