package com.sum2020.linked;

/**
 * @author guozhongdong
 * @date 2020/12/13 13:28
 *
 * 160. 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
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
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 思路：1、先判断两个链表是否相交
 *      2、在寻找相交的节点
 *
 * 解法一：先来嵌套for循环试一试
 *
 */
public class GetIntersectionNode_160 {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
       /* n1.next = n2;
        n2.next = n3;*/
        n1.next = node3;

        ListNode result =  new GetIntersectionNode_160().getIntersectionNode2(node,n1);
        System.out.println();
    }

    /**
     * 简单粗暴法，双层嵌套遍历
     *
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null){
            return null;
        }

        ListNode cur1 = headA;

        while (cur1 != null){
            ListNode hea = headB;
            while (hea != null){
                if (cur1 == hea){
                    return cur1;
                }else{
                    hea = hea.next;
                }
            }
            cur1 = cur1.next;
        }
        return null;
    }


    /**
     * 双指针法，a+b = b+a;
     * 两个链表的总长度是相等的，如果相交，在结束时，必会有相等的节点，
     * 所以判断总逻辑是 它俩的节点是否有相等的，
     * a+b = b+a 中间是消除了长度差，
     *
     * */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null){
            return null;
        }

        ListNode cur1 = headA;
        ListNode cur2 = headB;
        // 如果有相交，它俩节点比相等
        while (cur1 != cur2){

            cur1 = cur1 != null ? cur1.next : headB;
            cur2 = cur2 != null ? cur2.next : headA;

        }
        return cur1;
    }
}
