package com.sum2020.linked;

import java.util.Stack;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/10
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 *
 * 思路：两个链表对位相加，给两个链表分别入栈
 * 然后出栈，相加，唯一需要考虑的是 加之后大于10 ，需要把十位的数字，保留到下一次，
 * 而且判断的时候，不仅需要判断栈是否出完，还要判断 十位的数字，是否为0 ，如果为0 ，需要单独再给它加上一个节点。
 *
 */
public class AddTwoNumbers_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        while (l1 != null){

            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.add(l2.val);
            l2 = l2.next;
        }
        ListNode ans = null;
        if (stack1.size() >= stack2.size()){
            int num = 0;
            while (!stack1.isEmpty() || num != 0){
                int n1 = !stack1.isEmpty() ? (int) stack1.pop() :0;
                int n2 = !stack2.isEmpty() ? (int) stack2.pop() :0;
                int result = n1 + n2 + num;
                num = result/10;
                ListNode current = new ListNode(result%10);
                current.next = ans;
                ans = current;
            }
        }else{
            int num = 0;
            while (!stack2.isEmpty() || num != 0){
                int n1 = !stack1.isEmpty()  ? (int) stack1.pop() :0;
                int n2 = !stack2.isEmpty() ? (int) stack2.pop() :0;
                int result = n1 + n2 + num;
                num = result/10;
                ListNode current = new ListNode(result%10);
                current.next = ans;
                ans = current;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(7);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(3);


        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);


        new AddTwoNumbers_445().addTwoNumbers(node,node2);
    }
}
