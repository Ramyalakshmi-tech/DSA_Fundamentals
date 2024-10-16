package org.example;
import java.util.ArrayList;
import java.util.Collections;

class BinaryTreeNode {
    int data;
    BinaryTreeNode  left,right;

    BinaryTreeNode(int newData) {
        data = newData;
        left = right = null;
    }
}


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {-1,5},
                {5, 10},
                {5, 8},
                {10,9},
                {10,14},
                {8,4},
                {14,3}
        };

        BinaryTreeNode root = new BinaryTreeNode(arr[0][1]);
    BinaryTreeNode res=    inOrder(arr,root,root,0,0);

        printInOrder(res);
    }



    public static BinaryTreeNode inOrder(int[][] arr,BinaryTreeNode root,BinaryTreeNode parent,int i,int j) {
        if(root==null){
            return parent;
        }

        for(int k=0;k<arr.length;k++){
            if(arr[k][j]== root.data){
                if(root.left==null){
                    root.left =new BinaryTreeNode( arr[k][j + 1]);
                    System.out.println( "root="+root.data+ "left= "+root.left.data);
                }
                else{
                    root.right= new BinaryTreeNode(arr[k][j + 1]);
                    System.out.println("root="+root.data+"right= "+root.right.data);
                }
            }
        }
        if(root.left!=null)
            inOrder(arr,root.left,parent,i+1,j) ;
        if(root.right!=null)
            inOrder(arr,root.right,parent,i+1,j);
        return parent;
    }

    public static void printInOrder(BinaryTreeNode root){

       if(root==null){
           return;
       }
            printInOrder(root.left);
        System.out.println(root.data);
            printInOrder(root.right);

    }
}