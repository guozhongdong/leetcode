package com.primary.binarytree;

/**
 * @author gzd
 * @create 2018-06-19 13:49
 * @desc 二叉树的最大深度
 * 思路：使用递归操作
 *
 **/
public class MaxDepth {

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        new MaxDepth().maxDepth(node);
    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return  1;
        }else{
            int leftNum = maxDepth(root.left);
            int rightNum = maxDepth(root.right);
            if (leftNum > rightNum){
                return  leftNum+1;
            }else{
                return rightNum+1;
            }

        }
    }

}
