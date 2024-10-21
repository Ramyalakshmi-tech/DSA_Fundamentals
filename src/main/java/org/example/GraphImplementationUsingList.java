package org.example;

import java.util.ArrayList;
import java.util.List;

public class GraphImplementationUsingList {
    int vertices;
    ArrayList<ArrayList<Integer>> list;
     public GraphImplementationUsingList(int vertices){
         this.vertices=vertices;
         list=new ArrayList<>(vertices);
         for(int i=0;i<vertices;i++){
             list.add(new ArrayList<>());
         }
     }
    public  void AddEdge(int src,int dest){
        list.get(src).add(dest);
        list.get(dest).add(src);
    }
    public  void printList(){
        for(int i=0;i<vertices;i++){
            System.out.println();
            System.out.print(i+"->");
            int n=list.get(i).size();
            for(int j=0;j<n;j++){
                System.out.print(list.get(i).get(j)+" ");
            }
        }
    }
    public void removeEdge(int src,int dest){
       list.get(src).remove(Integer.valueOf(dest));
       list.get(dest).remove(Integer.valueOf(src));
    }
     public static  void main(String[] args){
         GraphImplementationUsingList listImpl=new GraphImplementationUsingList(4);
         listImpl.AddEdge(0,1);
         listImpl.AddEdge(1,2);
        listImpl. AddEdge(2,3);
       listImpl.  printList();
       listImpl.removeEdge(1,2);
         listImpl.  printList();
     }

}
