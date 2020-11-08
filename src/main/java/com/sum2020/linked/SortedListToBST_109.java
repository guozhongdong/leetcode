package com.sum2020.linked;

/**
 * @author gzd
 * @date 2020/11/8 下午3:32
 *
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 思路：找出根节点，中序遍历树，中序遍历还原树
 * 高度平衡，且高度差不超过1 ，说明得找这个链表的中位节点
 *
 * 递归，分别构建左子树和右子树
 * 中序遍历 LDR
 *
 */
public class SortedListToBST_109 {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new SortedListToBST_109().sortedListToBST(node);

    }
    ListNode globalHead ;
    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        TreeNode root = buildTree(0,len-1);

        return root;
    }

    /**
     * 构建树
     * */
    public TreeNode buildTree(int left,int right){

        if (left > right){
            return null;
        }
        //获取中位节点，这个节点要给树的根节点
        int mid = (left + right +1)/2;
        //递归弄左节点

        TreeNode root = new TreeNode();
        root.left = buildTree(left,mid-1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid+1,right);
        return root;
    }

     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
