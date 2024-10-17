package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GenericTreeNode {
    int data;
   ArrayList<GenericTreeNode> child;

    GenericTreeNode(int newData) {
        data = newData;
        child=new ArrayList<>();
    }
}
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class GenericTree {
    public static void main(String[] args) {
        int[][] arr = {
                {-1, 5},
                {5, 10},
                {5, 8},
                {5,7},
                {7,2},
                {10, 9},
                {10,1},
                {10, 14},
                {8, 4},
                {14, 3}
        };

        GenericTreeNode root = new GenericTreeNode(arr[0][1]);
        GenericTreeNode res = Helper(arr, root, root, -1, 0);

       // printInOrder(res);
        printLevelOrder(res);
    }


    public static GenericTreeNode Helper(int[][] arr, GenericTreeNode root, GenericTreeNode parent, int i, int j) {
        if (root == null) {
            return parent;
        }

        for (int k = 0; k < arr.length; k++) {
            if (arr[k][j] == root.data) {

                    root.child.add(new GenericTreeNode(arr[k][j+1]));
                    int n=root.child.size();
                    System.out.println("root=" + root.data + " child= " + root.child.get(n-1).data +" size= "+n);
               Helper(arr, root.child.get(n-1), parent, i + 1, j);
            }
        }



        return parent;
    }

    public static void printInOrder(GenericTreeNode root) {
       // System.out.println("InOrderroot= "+root.data);
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.child.size(); i++) {
            printInOrder(root.child.get(i));
        }
        System.out.print(root.data + " ");

    }

    public static void printLevelOrder(GenericTreeNode root){
        Queue<GenericTreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                GenericTreeNode node=q.poll();

                System.out.print(node.data+" ");
                for (int k = 0; k < node.child.size(); k++) {
                   q.offer(node.child.get(k));
                }
            }
        }
    }
}
