package com.sum2020.linked;

/**
 * @author guozhongdong
 * @date 2020/11/10 20:16
 * 725. 分隔链表
 *
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 * 示例 1：
 *
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 *
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 *
 * 分两部分，一个是k 大于链表 长度的，一个是k小于链表长度的。
 * 求商 ，求余
 * 商作为需要遍历的宽度，余作为每一部分需要额外添加的元素
 *
 */
public class SplitListToParts_725 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
       /* node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);*/

        new SplitListToParts_725().splitListToParts(node,5);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode[] result = new ListNode[k];
        ListNode newHead = root;
        while (newHead != null){
            count++;
            newHead = newHead.next;
        }
        // 分了几部分
        int width = count/k;
        // 多出来的一个元素
        int res =  count%k;
        newHead = root;
        for (int i = 0; i < k; i++) {
            //定义一个 隐形头结点，
            ListNode node = new ListNode(0),write = node;
            // i<res ? 1: 0 判断是否有余数，有的话，就得在每一部分给加上。
            for (int j = 0; j < width+(i < res?1:0); j++) {
                write.next = new ListNode(newHead.val);
                write = write.next;
                if (newHead != null){
                    newHead = newHead.next;
                }
            }
            result[i] = node.next;
        }

        return result;
    }
}
