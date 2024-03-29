package com.zjy.algorithm.linked;

/**
 * @author: zjy
 * @date: 2020/4/18 17:24
 */
public class HasCycle {

    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode former=head,latter=head;
        do{
            latter=latter.next;
            former=former.next.next;
        }while(latter!=null&&former!=null&&former.next!=null&&latter!=former);
        if(latter==former){
            return true;
        }else{
            return false;
        }
    }


}
