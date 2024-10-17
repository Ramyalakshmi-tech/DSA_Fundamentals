package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class   TreeNode {
    int data;
    TreeNode  left,right;

    TreeNode(int newData) {
        data = newData;
        left = right = null;
    }
}

public class levelOrderArray {

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

            TreeNode root = new TreeNode(arr[0][1]);
            Queue<TreeNode> queue=new LinkedList<>();
             TreeNode res=  Helper(arr,root,root,queue,0,0);

            printInOrder2(res);
        }
        public static TreeNode Helper(int[][] arr,TreeNode root,TreeNode parent,Queue<TreeNode> queue,int i,int j){
            queue.offer(root);

            while(!queue.isEmpty()) {
                int n = queue.size();
                  for(int k=0;k<n;k++) {
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");
              //  root = node;
                ArrayList<Integer> count = new ArrayList<>();
                if (i + 1 < arr.length) {
                    if (arr[i + 1][j] == node.data) {

                        node.left = new TreeNode(arr[i + 1][j + 1]);
                        queue.offer(node.left);
                        count.add(2);
                        System.out.println(" root " + root.data + " left " + root.left.data);
                    }
                }
                if (i + 2 < arr.length) {
                    if (arr[i + 2][j] == node.data) {


                        node.right = new TreeNode(arr[i + 2][j + 1]);
                        queue.offer(node.right);
                        count.add(1);
                        System.out.println(" root " + root.data + " right " + root.right.data);
                    }
                }

                if (count.size() == 2) {
                    i = i + 2;
                }
                if (count.size() == 1) {
                    i++;
                }
                // System.out.println("index "+i);
            }
            }
System.out.println(" Parent "+parent.data);
            System.out.println(" rootleftleft "+root.data);
            return root;
        }

public static void printInOrder2(TreeNode root){
            if(root==null){
                return;
            }
            printInOrder2(root.left);
            System.out.print(root.data+" ");
            printInOrder2(root.right);
}
    }
