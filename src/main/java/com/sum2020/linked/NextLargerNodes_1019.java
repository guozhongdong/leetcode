package com.sum2020.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author guozhongdong
 * @date 2020/11/26 19:46
 *
 * 1019. 链表中的下一个更大节点
 *
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 
 * 是 node_j.val，
 * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。
 * 如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）
 * 是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 *
 * 递归 从后面往前判断，
 * 条件是遍历到最后一个节点
 *
 * 每一次要做的事，就是比较两个节点，谁大谁小
 *
 * 返回给上一层已经判断好的节点
 *
 * 单调栈，先遍历一遍数据，放到一个集合中，
 * 从后遍历集合，遇到比自己大的之前，都入栈，遇到大的节点，则都出栈，将大的节点值入栈
 *
 */
public class NextLargerNodes_1019 {

    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(7);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(5);

        //[1,7,5,1,9,2,5,1]
        //[9,9,9,9,0,5,0,0]
        //[7,9,9,9,0,5,0,0]

        /*node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(5);*/
        new NextLargerNodes_1019().nextLargerNodes(node);
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (head != null){
            count++;
            list.add(head.val);
            head = head.next;
        }
        //建立一个栈，存放较大的数，
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[count];
        //倒着遍历，好入栈
        for (int i = list.size()-1; i >=0 ; i--) {
            while (!stack.empty() && stack.peek() <= list.get(i)){
                //把小的节点都出栈
                stack.pop();
            }
            arr[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i));

        }

        return arr;

    }



}
