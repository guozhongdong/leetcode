package com.sum2020.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzd
 * @date 2020/11/17 下午9:54
 *
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 考察点：主要是得理解题意，第一个公共节点，即值和所在的地址都相等，
 *
 * 双指针，集合法
 */
public class GetIntersectionNode_52 {

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(8);
        ListNode root3 = new ListNode(4);
        ListNode root4 = new ListNode(5);

        ListNode sec = new ListNode(5);
        ListNode sec1 = new ListNode(0);
        ListNode sec2 = new ListNode(1);

        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;

        sec.next = sec1;
        sec1.next = sec2;
        sec2.next = root2;

        ListNode result = new GetIntersectionNode_52().getIntersectionNode2(root,sec);
        System.out.println();

    }
    /**
     * 双指针法，让每个指针都把两个链表走一遍，最终会相交的
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode t1 = headA;
        ListNode t2 = headB;
        while (t1 != t2){
            t1 = t1 == null ? headB : t1.next;
            t2 = t2 == null ? headA : t2.next;
        }
        return t1;
    }

    /**
     * 集合法
     * */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode t1 = headA;
        ListNode t2 = headB;
        while (t1 != null){
            set.add(t1);
            t1 = t1.next;
        }
        while (t2 != null){
            if (set.contains(t2)){
                return t2;
            }
            t2 = t2.next;
        }
        return null;
    }


}
