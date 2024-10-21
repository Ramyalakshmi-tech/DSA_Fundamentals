package org.example;

class GraphImplementationUsingMat {
    int vertices;
    int[][] mat;
    public GraphImplementationUsingMat(int vertices){
        this.vertices=vertices;
        mat=new int[vertices][vertices];
    }
    public void addEdge(int src,int dest){
        mat[src][dest]=1;
        mat[dest][src]=1;
    }
    public void printMatrix(){
        for(int i=0;i<vertices;i++){
            System.out.println();
            for(int j=0;j<vertices;j++){
                 System.out.print(mat[i][j]+" ");
            }
        }
    }
    public void removeEdge(int src,int dest){
        mat[src][dest]=0;
        mat[dest][src]=0;

    }
    public static  void main(String[] args){
        GraphImplementationUsingMat matrix=new GraphImplementationUsingMat(4);
        matrix.addEdge(0,1);
        matrix.addEdge(1,2);
        matrix.addEdge(2,3);
        matrix.printMatrix();
    }
}


