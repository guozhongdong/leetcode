package com.sum2020.tree;

/**
 * @author guozhongdong
 * @date 2020/8/7
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * 基本思路：遍历插值，具体使用哪种遍历的方式
 * 前序遍历即可 DLR
 * 提示了二叉搜索树，要了解它的特性
 */
public class SearchBST_700 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode node = new SearchBST_700().searchBST(root,2);
        System.out.println(node);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val == val){

            return root;
        }else if (val > root.val){
            return searchBST(root.right,val);
        }else {
           return searchBST(root.left,val);
        }
    }


}
