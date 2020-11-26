package com.sum2020.linked;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author guozhongdong
 * @date 2020/11/25 20:34
 *
 * 148. 排序链表
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *  每一次遍历把最大的放后面，第一次移动n-1次，
 *
 */
public class SortList_148 {

    public static void main(String[] args) {

        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(1);
        new SortList_148().sortList2(node);

    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        List<Integer> result = new ArrayList<>();
        ListNode newHead = head;

        while (newHead != null){
            result.add(newHead.val);
            newHead = newHead.next;
        }

        Collections.sort(result);
        ListNode node = new ListNode(result.get(0));
        ListNode jie = node;
        for (int i = 1; i < result.size(); i++) {
            node.next = new ListNode(result.get(i));
            node = node.next;
        }
        return jie;
    }

    /**
     * 递归 每次比较两个数，大数往后移，最红
     * */
    public ListNode sortList2(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        List<Integer> result = new ArrayList<>();
        ListNode newHead = head;
        ListNode cur = head.next;

        while (newHead != null){
            while (cur != null){
                if (newHead.val > cur.val){
                    newHead.next = cur.next;
                    cur.next = newHead;
                    cur = newHead;
                }else{
                    cur = cur.next;
                }
            }
            newHead = newHead.next;
        }

        return null;

    }
}
