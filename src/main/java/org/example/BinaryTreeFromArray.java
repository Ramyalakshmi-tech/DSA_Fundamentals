package org.example;

import java.util.ArrayList;
import java.util.List;
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
        BinaryTreeNode2 root=new BinaryTreeNode2(nums[nums.length/2]);
        BinaryTreeNode2 res=BuildTree(nums,0,nums.length,root,root);

    }

    public static BinaryTreeNode2 BuildTree(int[] nums,int start,int end,BinaryTreeNode2 root, BinaryTreeNode2 parent){
       if(start<0 || end>nums.length){
           return parent;
       }
      int mid=start+(end-start)/2;
     BinaryTreeNode2 node=new BinaryTreeNode2(nums[mid]);
        System.out.println("root "+root.data);

         root.left=BuildTree(nums,0,mid-1,node,parent);
         System.out.println("root "+root.data+" left "+root.left.data+" right "+root.right.data);

         root.right=BuildTree(nums,mid+1,end,node,parent);
        System.out.println("root "+root.data+" left "+root.left.data+" right "+root.right.data);

         return parent;

    }

}

