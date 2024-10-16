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
                {-1,8},
                {8, 5},
                {8, 10},
                {5, 1},
                {5, 7},
                {10, 12}
        };

        BinaryTreeNode root = new BinaryTreeNode(arr[0][1]);
    BinaryTreeNode res=    inOrder(arr,root,root,0,0);
        printInOrder(res);
    }



    public static BinaryTreeNode inOrder(int[][] arr,BinaryTreeNode root,BinaryTreeNode parent,int i,int j) {
        if(root==null){
            return root;
        }
      //root
        if(arr[i+1][j]==root.data){
            if(root.data>arr[i+1][j+1]) {
                root.left =new BinaryTreeNode( arr[i + 1][j + 1]);
                System.out.println( "root="+root.data+ "left= "+root.left.data);
            }
            else {
                root.right= new BinaryTreeNode(arr[i + 1][j + 1]);
                System.out.println("root="+root.data+"right= "+root.right.data);
            }

            }
        if(arr[i+2][j]==root.data){
            if(root.data>arr[i+2][j+1]) {
                root.left =new BinaryTreeNode( arr[i + 2][j + 1]);
                System.out.println( "root="+root.data+ "left= "+root.left.data);
            }
            else {
                root.right= new BinaryTreeNode(arr[i + 2][j + 1]);
                System.out.println("root="+root.data+"right= "+root.right.data);
            }

        }

     //   inOrder(arr,root,parent,i+1,j) ;
        if(root.left!=null)
            inOrder(arr,root.left,parent,i+1,j) ;
        if(root.right!=null)
            inOrder(arr,root.right,parent,i+1,j);
        return root;
    }

    public static void printInOrder(BinaryTreeNode root){

        while(root!=null) {
            printInOrder(root.left);
       //   System.out.println(root.data);
            printInOrder(root.right);
        }
    }
}