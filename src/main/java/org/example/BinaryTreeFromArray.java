package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class   BinaryTreeNode2 {
    int data;
    BinaryTreeNode2  left,right;

    BinaryTreeNode2(int newData) {
        data = newData;
        left = right = null;
    }
}
public class BinaryTreeFromArray {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        int n=nums.length-1;
        BinaryTreeNode2 root=new BinaryTreeNode2(nums[0]);
        Queue<BinaryTreeNode2> queue=new LinkedList<>();
      BinaryTreeNode2 res=  Helper(root,queue,0,nums);
      printInOrder(res);
    }

    public static BinaryTreeNode2 Helper(BinaryTreeNode2 root,Queue<BinaryTreeNode2> queue,int k,int[] nums){
        queue.offer(root);
        while(!queue.isEmpty()){
            int n= queue.size();
            for(int i=0;i<n;i++){
                BinaryTreeNode2 node=queue.poll();
                if(k+1<nums.length) {
                    node.left = new BinaryTreeNode2(nums[k + 1]);
                    queue.offer(node.left);
                    k++;

                }
                if(k+1<nums.length){
                    node.right=new BinaryTreeNode2(nums[k+1]);
                    queue.offer(node.right);
                    k++;

                }

              //  System.out.println(" root "+node.data+" left "+node.left.data+" right "+node.right.data);
            }
        }
        return root;
    }
    public static void printInOrder(BinaryTreeNode2 root){

        if(root==null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);

    }

    }



