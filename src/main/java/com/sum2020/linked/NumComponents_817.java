package com.sum2020.linked;

import java.util.*;

/**
 * @author guozhongdong
 * @date 2020/10/28 20:11
 *
 * 817. 链表组件
 *
 *
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 *
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 *
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 *  
 *
 * 提示：
 *
 * 如果 N 是给定链表 head 的长度，1 <= N <= 10000。
 * 链表中每个结点的值所在范围为 [0, N - 1]。
 * 1 <= G.length <= 10000
 * G 是链表中所有结点的值的一个子集.
 *
 * 组件的定义:如果列表中的节点在链表中是连续的，且下一个节点不在链表中，则形成了一个组件
 * 计数器+1，否则链表往后继续走
 *
 */
public class NumComponents_817 {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        int[] G = {0,3,1,4};
        System.out.println(new NumComponents_817().numComponents(node, G));
    }


    public int numComponents(ListNode head, int[] G) {

        //将列表的数存储到容器中
        ListNode root = head;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }
        // 开始遍历链表
        while (root != null){
            if (set.contains(root.val) && (root.next == null || !set.contains(root.next.val))){
                ans++;
            }
            root = root.next;
        }


        return ans;
    }
}
