package com.zjy.algorithm.array;

/**
 * @author: zhaojianyang
 * @date: 2020/4/16 16:05
 */
public class MoveZeros {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
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
