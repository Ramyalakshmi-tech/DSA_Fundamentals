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

class Tree{

}
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(arr[i][j+1]);
        inOrder(arr,root,root,0,0);
    }



    public BinaryTreeNode inOrder(int[][] arr,BinaryTreeNode root,BinaryTreeNode parent,int i,int j) {
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


        return inOrder(arr,root.left,i+1,j) && inOrder(arr,root.right,i+1.j);
    }
}