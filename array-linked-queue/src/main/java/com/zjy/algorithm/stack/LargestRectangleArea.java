package com.zjy.algorithm.stack;

import java.util.Stack;

/**
 * @author: zjy
 * @date: 2020/4/21 18:29
 */
public class LargestRectangleArea {

    /**
     * 柱状图中最大的矩形
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
     *
     * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
     *
     * 示例:
     *
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     */

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        int i = largestRectangleArea(nums);
        System.out.println(i);
    }


    /**
     * 主要看的就是栈顶端的那个柱子往右能组成的最大面积
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i < heights.length;i++){
                while(stack.peek() != -1 && heights[stack.peek()] > heights[i]){
                    int nowArea = heights[stack.pop()]*(i - stack.peek() -1);
                    maxArea = Math.max(maxArea,nowArea);
                }
                stack.push(i);


        }
        while(stack.peek() != -1){
            int value = stack.pop();
            int nowArea = heights[value]*(heights.length - stack.peek() -1);
            maxArea = Math.max(maxArea,nowArea);
        }
        return maxArea;

    }


}
