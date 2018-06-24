package com.primary.listnode;

/**
 * @author gzd
 * @create 2018-06-24 14:42
 * @desc:环形链表
 * 给定一个链表判断其中是否有环
 * 思路1： 利用额外的空间 set ，判断，set添加重复元素 返回false
 * 思路2：利用 Floyd判圈算法 龟兔赛跑算法,设置一个慢节点 和一个快节点，快节点是慢节点的2倍，
 *       当他们相遇的时候，就说明有环，
 **/
public class CycleLists {

    public boolean hasCycle(ListNode head) {
        /*  思路1
        if (head == null || head.next == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null ){
           if (!set.add(head))
            return true;
            head  = head.next;
        }
        return false;*/
         // 思路2 不使用额外的空间
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
