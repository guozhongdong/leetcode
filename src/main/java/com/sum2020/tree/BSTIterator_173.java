package com.sum2020.tree;


import java.util.LinkedList;

/**
 * @author gzd
 * @date 2020/7/1 下午9:49
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * 采用前序遍历，从小到大遍历树，并将结果存到一个链表中
 * 取的时候，取一个少一个，
 *
 * 核心知识点是考察二叉树的 中序遍历，而且是升序遍历
 *
 */
public class BSTIterator_173 {

    public static LinkedList list = new LinkedList();
    public BSTIterator_173(TreeNode root) {
        search(root);

    }

    public void search(TreeNode tree){
        if (tree == null){
            return;
        }
        search(tree.left);
        list.add(tree.val);
        search(tree.right);

    }

    /** @return the next smallest number */
    public int next() {

        return (int) list.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return list.size()>0;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator_173 object = new BSTIterator_173(root);
        System.out.println(list);
        int param_1 = object.next();
        int param_3 = object.next();
        boolean param_2 = object.hasNext();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
