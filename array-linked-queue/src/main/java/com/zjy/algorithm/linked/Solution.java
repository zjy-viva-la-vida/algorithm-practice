package com.zjy.algorithm.linked;

/**
 * @author: zjy
 * @date: 2020/4/18 17:43
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        ListNode former=head,latter=head;
        do{
            latter=latter.next;
            former=former.next.next;
        }while(latter!=null&&former!=null&&former.next!=null&&latter!=former);
        if(latter==former)return true;
        else return false;
    }
}
