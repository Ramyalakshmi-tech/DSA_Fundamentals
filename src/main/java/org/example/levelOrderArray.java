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
            Queue<Integer> queue=new LinkedList<>();
             TreeNode res=  Helper(arr,root,root,queue,0,0);

          //  printInOrder(res);
        }
        public static TreeNode Helper(int[][] arr,TreeNode root,TreeNode parent,Queue<Integer> queue,int i,int j){
            queue.offer(root.data);

            while(!queue.isEmpty()){
                int n=queue.size();
                for(int k=0;k<n;k++) {
                    int node = queue.poll();
                    System.out.print(node+" ");
                 //   root.data=node;
                    ArrayList<Integer> count=new ArrayList<>();
                    if(i+1<arr.length) {
                        if (arr[i + 1][j] == node) {
                            queue.offer(arr[i + 1][j+1]);
                            //  root.left=new TreeNode(arr[i + 1][j+1]);
                            count.add(2);
                         //   System.out.println(" root "+root.data+" left "+root.left.data);
                        }
                    }
                    if(i+2<arr.length) {
                        if (arr[i + 2][j] == node) {
                            queue.offer(arr[i + 2][j + 1]);
                          //  root.right=new TreeNode(arr[i + 2][j+1]);
                            count.add(1);
                         //   System.out.println(" root "+root.data+" right "+root.right.data);

                        }
                    }



                    if(count.size()==2){
                        i=i+2;
                    }
                    if(count.size()==1){
                        i++;
                    }
                   // System.out.println("index "+i);
                }
            }

            return root;
        }


    }
