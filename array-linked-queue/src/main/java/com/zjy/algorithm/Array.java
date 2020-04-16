package com.zjy.algorithm;

/**
 * @author: zhaojianyang
 * @date: 2020/4/16 16:05
 */
public class Array {
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,11,7,53,6};
        int j = 0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i] != 0){
//                nums[j] = nums[i];
//                if(i != j){
//                    nums[i] = 0;
//                }
//                j++;
//            }
//        }
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
        int[] newNums = new int[nums.length];
        int m = nums.length -1;
        int n =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                newNums[m] = nums[i];
                m--;
            }else{
                newNums[n] = nums[i];
                n++;
            }
        }

        System.out.println();
        for (int num : newNums) {
            System.out.print(num + " ");
        }


//        int p = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] != 0 ){
//                int temp = nums[p];
//                nums[p] = nums[i];
//                nums[i] = temp;
//                p++;
//            }
//        }


        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }

        System.out.println();
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
