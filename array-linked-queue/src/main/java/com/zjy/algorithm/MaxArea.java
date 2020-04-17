package com.zjy.algorithm;

/**
 * @author: zhaojianyang
 * @date: 2020/4/17 15:22
 */
public class MaxArea {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
//        int maxArea = maxArea(nums);
        int maxArea = maxAreaNes(nums);
        System.out.println(maxArea);
    }

    /**
     * 时间复杂度O(n^2)，经历了两次循环
     * @param nums
     * @return
     */
    public static int maxArea(int[] nums){
        int max = 0;
        for(int i = 0;i < nums.length - 1;i++){
            for(int j = i + 1;j<nums.length;j++){
                int area = (j - i)*Math.min(nums[i],nums[j]);
                max = Math.max(max,area);
            }
        }
        return max;
    }

    /**
     * 时间复杂度O(n)，左右边界i,j向中间收敛；左右夹逼
     * @param nums
     * @return
     */
    public static int maxAreaNes(int[] nums){
        int max = 0;
        for(int i = 0, j = nums.length-1;i < j;){
            int minHeight = nums[i] < nums[j]?nums[i++]:nums[j--];
            //因为上面执行了++或--操作，所以下面计算宽度需要加1
            int area = (j - i + 1) * minHeight;
            max = Math.max(area,max);
        }
        return max;
    }

}


