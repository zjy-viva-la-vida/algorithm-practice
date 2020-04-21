package com.zjy.algorithm.linked;

/**
 * @author: zhaojianyang
 * @date: 2020/4/18 16:07
 */
public class SwapPairs {

    /**
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode pre = root;
        for(int i = 1;i< 7;i++){
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        ListNode listNode = swapPairsNew(root.next);
        System.out.println("ssssss:" + ReverseList.listNodeToString(listNode));
    }


    /**
     * 从链表的头节点 head 开始递归。
     * 每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点。
     * 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
     * 交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
     * 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。
     * 时间复杂度：O(N)，其中 N 指的是链表的节点数量。
     * 空间复杂度：O(N)，递归过程使用的堆栈空间。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }


    /**
     * 方法二：迭代
     * 我们把链表分为两部分，即奇数节点为一部分，偶数节点为一部分，A 指的是交换节点中的前面的节点，B 指的是要交换节点中的后面的节点。在完成它们的交换，我们还得用 prevNode 记录 A 的前驱节点。
     *
     * 算法：
     *
     * firstNode（即 A） 和 secondNode（即 B） 分别遍历偶数节点和奇数节点，即两步看作一步。
     * 交换两个节点：
     *  firstNode.next = secondNode.next
     *  secondNode.next = firstNode
     * 还需要更新 prevNode.next 指向交换后的头。
     * prevNode.next = secondNode
     * 迭代完成后得到最终的交换结果。
     * @param head
     * @return
     */
    public static ListNode swapPairsNew(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode prevNode = root;

        while (head != null && head.next != null ) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }
        return root.next;
    }


}
