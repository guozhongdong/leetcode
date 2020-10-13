package com.sum2020.tree;

/**
 * @author guozhongdong
 * @date 2020/10/13 20:33
 *
 *
 *
 * 递归训练

 *
 *  
 *
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  


 *  一、终止条件，
 *         树遍历完，返回0 ，深度是根节点到叶子节点的距离+1
 *
 *  二、每一层做了什么
 *
 *      计算当前节点到叶子节点的最小深度，即到左节点的深度和到右节点的深度，取一个最小值
 *
 *  三、每一层返回了什么
 *     最小的深度值
 *
 *
 */
public class RecursionTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        new RecursionTest().test1(root);
        System.out.println();
    }
    /**
     * 111. 二叉树的最小深度
     * */
    public int test(TreeNode root){
        //1、终止条件
        if (root == null){
            return 0;
        }
        //2、这一层要做的事，计算左右节点的深度值
        int left = test(root.left);
        int right = test(root.right);
        //考虑一种特殊的情况，左右子节点有一方没有的话，不能以最小的算，
        if (left == 0 || right == 0){
            return left + right +1;
        }
        //3、返回给上一级节点一个最小的深度值
        return Math.min(left,right)+1;

    }
    /**
     * 翻转二叉树
     * */
    public void test1(TreeNode root){
        //1、终止条件,遍历完树就终止了，说明翻转完了，
        if (root == null){
            return ;
        }
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;
        test1(root.left);
        test1(root.right);

    }


}
