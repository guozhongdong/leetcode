package com.sum2021.strings.huiwen;

import com.medium.linked.ListNode;

/**
 * @author guozhongdong
 * @date 2021/3/9 20:27
 *
 * 判断一个字符串是否是回文
 * 双指针判断
 */
public class HuiWen {

    public static void main(String[] args) {
        String str = "abcddcba";
        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(2);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(2);
        ListNode root5 = new ListNode(1);
        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;

        //new HuiWen().reverseNode(root);
        //System.out.println(new HuiWen().huiwen(str));
        System.out.println(new HuiWen().huiwen1(root));
    }

    public boolean huiwen(String str){
        if (str == null){
            return true;
        }
        int start = 0;
        int end = str.length()-1;

        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
    /**
     * 判断一个单链表是不是回文
     * 单链表是单向的，如何取出头和尾两个指针
     *
     * */
    public boolean huiwen1(ListNode node){
        if (node == null){
            return true;
        }
        ListNode fast = node;
        ListNode slow = node;
        ListNode curNode = node;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //翻转slow的后半部分
        ListNode newHead = reverseNode(slow);
        while (newHead != null){
            if (curNode.val != newHead.val){
                return false;
            }
            newHead = newHead.next;
            curNode = curNode.next;
        }
        System.out.println("");
        return true;

    }

    private ListNode reverseNode(ListNode root){
        if (root == null){
            return null;
        }
        ListNode newHead = null;
        ListNode node = root;
        while (node != null){
            ListNode cur = new ListNode(node.val);
            cur.next = newHead;
            newHead =cur;
            node = node.next;
        }
        return newHead;
    }
}
