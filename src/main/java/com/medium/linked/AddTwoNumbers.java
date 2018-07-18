package com.medium.linked;

/**
 * @author gzd
 * @create 2018-07-18 21:17
 * @desc 两数相加
 *
 **/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = l1;
        ListNode secode = l2;

        ListNode third = new ListNode(0);
        ListNode r = third;
        third.next = l1;
        int carry = 0; // 进位
        int sum;
        while ( head  != null && secode != null){
            sum = head.val + secode.val + carry;
            head.val = sum % 10; // 本位的结果
            carry = sum / 10; // 本次进位

            r.next = head;
            r = head; // 指向最后一个相加的结点
            head = head.next;
            secode = secode.next;
        }

        if (head == null) {
            r.next = secode;
        } else {
            r.next = head;
        }

        // 最后一次相加还有进位
        if (carry == 1) {
            // 开始时r.next是第一个要相加的结点
            while (r.next != null) {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }

            // 都加完了还有进位，就要创建一个新的结点
            if (carry == 1) {
                r.next = new ListNode(1);
            }
        }

        return third.next;

    }
}
