package com.zjy.algorithm;

/**
 * @author: zhaojianyang
 * @date: 2020/4/17 16:17
 */
public class ClimbStairs {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int result = climbStairsNew(232323);
        System.out.println(result);
    }

    /**
     * 时间复杂度：O(2^n)，树形递归的大小为 2^n2
     * 1:1
     * 2:2
     * 3： f(1) + f(2)
     * 4: f(3) + f(2)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n < 3){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 方法二：斐波那契数
     * 在上述方法中，我们使用 dpdp 数组，其中 dp[i]=dp[i-1]+dp[i-2]dp[i]=dp[i−1]+dp[i−2]。可以很容易通过分析得出 dp[i]dp[i] 其实就是第 ii 个斐波那契数。
     *
     * Fib(n)=Fib(n-1)+Fib(n-2)
     * Fib(n)=Fib(n−1)+Fib(n−2)
     *
     * 现在我们必须找出以 11 和 22 作为第一项和第二项的斐波那契数列中的第 nn 个数，也就是说 Fib(1)=1Fib(1)=1 且 Fib(2)=2Fib(2)=2。
     * 时间复杂度：O(n)O(n)，单循环到 nn，需要计算第 nn 个斐波那契数。
     *
     * 空间复杂度：O(1)O(1)，使用常量级空间。
     * @param n
     * @return
     */
    public static int climbStairsNew(int n) {
        if(n < 2){
            return n;
        }
        int first = 1;
        int second = 2;
        for(int i = 3;i <= n;i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
