package com.sum2020.tree;


/**
 * @author gzd
 * @date 2020/7/8 下午9:33
 *
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 *
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 *
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
 *
 *  翻转等价二叉树
 *
 * 示例：
 *
 * 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * 输出：true
 * 解释：我们翻转值为 1，3 以及 5 的三个节点。
 *
 *  
 *
 * 提示：
 *
 * 每棵树最多有 100 个节点。
 * 每棵树中的每个值都是唯一的、在 [0, 99] 范围内的整数。
 *
 *  编写一个函数，判断两个树的根节点和它的左右子节点是否相等，
 *  如果都相等，则符合翻转，递归各自的子节点
 *  类比比较两个树相等的情况，一般都是递归比较各个的子节点
 */
public class FlipEquiv_951 {


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right.left = new TreeNode(6);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(7);
        root2.right.right.right = new TreeNode(8);
        root2.left.right = new TreeNode(6);

        /*TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(1);
        root1.right.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(2);*/

        System.out.println(new FlipEquiv_951().flipEquiv(root1, root2));
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        }
        return checkStatus(root1,root2);
    }


    public boolean checkStatus(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }

        if (root1 == null || root2 == null){
            return false;
        }

        // 如果根不相等，就直接pass了
        if (root1.val != root2.val){
            return false;
        }

        return (checkStatus(root1.left,root2.right) && checkStatus(root1.right,root2.left)) ||
                (checkStatus(root1.left,root2.left) && checkStatus(root1.right,root2.right));
    }

}
