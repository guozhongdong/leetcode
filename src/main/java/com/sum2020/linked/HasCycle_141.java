package com.sum2020.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * @author guozhongdong
 * @date 2020/12/14 20:49
 * 141. 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *  
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 *
 * 找环就类似于相交，双指针，
 * 或者用去重集合判断
 *
 *
 */
public class HasCycle_141 {
    Set<ListNode> set = new HashSet<>();
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        boolean result = new HasCycle_141().hasCycle2(node);
        System.out.println(result);
    }
    // set集合，空间不符合优化原则
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode cur = head;
        while (cur != null){
            if (set.contains(cur)){
                return true;
            }else{
                set.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }
    /**
     *
     * 快慢指针法，
     * 快指针一次两步，
     * 慢指针一次一步，如果他们有相交，则慢指针走完的时候，他们一定会相等
     * */
    public boolean hasCycle2(ListNode head) {
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
