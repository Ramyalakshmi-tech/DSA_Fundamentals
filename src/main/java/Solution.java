class Solution {
    public static int[] search(int[] nums, int index,int number) {
        int i=0;
     for(i=nums.length-1;i>index;i--){
         nums[i]=nums[i-1];
     }
     nums[i]=number;
     return nums;
    }
    public static void main(String[] args){
        int[] nums=new int[10];
        nums[0]=1;
        nums[1]=2;
        nums[2]=3;
        nums[3]=4;
        nums[4]=5;
        int index=1;
        int number=6;
        search(nums,index,number);

        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}