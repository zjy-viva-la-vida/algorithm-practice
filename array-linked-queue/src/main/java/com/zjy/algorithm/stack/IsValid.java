package com.zjy.algorithm.stack;

import java.util.Stack;

/**
 * @author: zjy
 * @date: 2020/4/21 15:12
 */
public class IsValid {

    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * @param args
     */

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));

    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if('(' == c){
                stack.push(')');
            }else if('[' == c){
                stack.push(']');
            }else if('{' == c){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
