package com.primary.listnode;

/**
 * @author gzd
 * @create 2018-06-24 14:36
 * @desc 合并两个有序的链表
 * 思路：递归判断 l1 的节点与l2的节点 值的大小，
 **/
public class MergeTwoLists {
    public static void main(String[] args){

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null){
            if (l1 == null && l2 == null){
                return null;
            }else{
                return l1 == null? l2:l1;
            }
        }
        ListNode result = null;
        if (l1.val < l2.val){
            result  = l1;
            result.next = mergeTwoLists(l1.next,l2);
        }else{
            result = l2;
            result.next = mergeTwoLists(l2.next,l1);
        }

        return result;
    }
}
