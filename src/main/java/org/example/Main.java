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
                {8, 5},  // 8 is the parent of 5
                {8, 10}, // 8 is the parent of 10
                {5, 1},  // 5 is the parent of 1
                {5, 7},  // 5 is the parent of 7
                {10, 12} // 10 is the parent of 12
        };

        BinaryTreeNode root = new BinaryTreeNode(arr[0][1]);
    BinaryTreeNode res=    inOrder(arr,root,root,0,0);
        printInOrder(res);
    }



    public static BinaryTreeNode inOrder(int[][] arr,BinaryTreeNode root,BinaryTreeNode parent,int i,int j) {
        if(root==null){
            return parent;
        }
      //root
        if(arr[i+1][j]==root.data){
            if(root.data<arr[i+1][j+1]) {
                root.left.data = arr[i + 1][j + 1];
            }
          else {
                root.right.data = arr[i + 1][j + 1];
            }

            }


        inOrder(arr,root.left,parent,i+1,j) ;
        inOrder(arr,root.right,parent,i+1,j);
        return parent;
    }

    public static void printInOrder(BinaryTreeNode root){
        if(root==null){
            return ;
        }
        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }
}