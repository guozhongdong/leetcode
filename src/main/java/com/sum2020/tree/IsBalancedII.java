package com.sum2020.tree;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/8
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
  思路：大的方向就是递归获取左右子树的最大深度，并判断他们的差是否大于1
  第一波代码，没有考虑子树的子树，只考虑根节点的左右子节点，再往下没有遍历了，
 按题解，这一个属于从上到底的遍历
  二叉树的深度 = 左子树或右子树深度的最大值 +1;
 */
public class IsBalancedII {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(new IsBalancedII().isBalanced2(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int level = 0;
        if (Math.abs(getDepth(root.left,level) - getDepth(root.right,level)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root,int level){
        if (root == null){
            return level;
        }
        level++;
        return Math.max(getDepth(root.left,level),getDepth(root.right,level));
    }

    /**
     * 方法二 采用后续遍历和剪枝的方法
     * -1 作为一个判断标识，如果左右子树的深度差大于2，说明不是平衡数，返回 -1
     * 如果<= 1,则说明是平衡数，返回树的深度，即 左子树或右子树的最大深度 +1
     * */
    public boolean isBalanced2(TreeNode root) {

        return reduce(root) != -1;
    }
    /**
     * 正常会返回树的深度
     * */
    public int reduce(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = reduce(root.left);
        if (left == -1){
            return -1;
        }
        int right = reduce(root.right);
        if (right == -1){
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left,right)+1 : -1;
    }



}
