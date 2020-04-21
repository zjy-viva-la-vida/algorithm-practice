package com.zjy.algorithm.linked;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: zhaojianyang
 * @date: 2020/4/18 11:06
 */
public class ReverseList {

    /**
     * 反转一个单链表。
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nodeValues = {1,2,3,4,5};

        // Now convert that list into linked list
        ListNode root = new ListNode(0);
        ListNode ptr = root;
        for(int value : nodeValues) {
            ptr.next = new ListNode(value);
            ptr = ptr.next;
        }
        ListNode listNode = reverseList2(root.next);
        System.out.println("ssssss:" + listNodeToString(listNode));

        ListNode root2 = new ListNode(0);
        ListNode pre = root2;
        for(int i = 11;i< 20;i++){
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        System.out.println("ffffffffffff:" + listNodeToString(root2.next));
        ListNode listNode2 = reverseList(root2.next);
        System.out.println("ffffffffffff:" + listNodeToString(listNode2));

    }


    /**
     * 方法一：迭代
     * 假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
     *
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     * 时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head == null || head.next == null) {
            return head;
        }
        System.out.println("1111111111111111111111");
        //这里的cur就是最后一个节点
        ListNode cur = reverseList2(head.next);
        System.out.println("222222222222222");
        System.out.println("3333333:" + cur.val);
        System.out.println("444444:" + head.val);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

}
