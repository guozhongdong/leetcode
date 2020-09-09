package com.sum2020.linked;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/9
 * 经典第一题 反转链表
 *
 * 思路：将第一个节点和第二个节点先反转，依次递归，
 * 找一个节点存放当前节点的下一个节点
 * 更新当前节点
 * 更新主节点
 *
 * 简单粗暴的方法，就是遍历两次
 *
 */
public class ReverseLinked {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        new ReverseLinked().reverseLinked(node);
    }
    /**
     * 反转链表
     *
     **/
    public ListNode reverseLinked(ListNode node){
        if (node == null){
            return node;
        }
        ListNode pre ,cur;
        pre = node; //专门用来存放 当前节点的下一个节点值，遍历一次存放一个值，且不变，等待下次遍历更新
        cur = node.next; // 指遍历到的当前节点
        while (cur != null){

            pre.next = cur.next; // 保存3
            cur.next = node ;
            node = cur;  //指遍历的节点
            cur = pre.next;
        }
        return node;
    }
}
