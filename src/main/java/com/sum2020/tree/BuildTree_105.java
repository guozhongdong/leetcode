package com.sum2020.tree;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzd
 * @date 2020/4/8 下午8:36
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 思路：了解前序和中序遍历的思路，
 * 前： DLR
 * 中： LDR
 *
 * 最终的目的是构建一颗二叉树
 *
 * 思路：根据前序遍历，找出根节点，
 * 在根据根节点在 中序遍历的数组里，给中序遍历分一个 左右节点，在根节点左边的构建左子树，在根节点右边的构建右子树
 * 递归
 */
public class BuildTree_105 {
    int pre_ix = 0;
    int[] qian;
    int[] zhong;
    Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int[] qian = {3,9,20,15,7};
        int[] zhong = {9,3,15,20,7};
        TreeNode node = new BuildTree_105().buildTree(qian,zhong);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.qian = preorder;
        this.zhong = inorder;
        // 把中序遍历的值放到一个map中，并分别记录它的下标
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return helperTree(0,inorder.length);
    }
    public TreeNode helperTree(int left,int right){

        if (left == right){
            return null;

        }
        // 根据前序遍历取根节点的值,得到根节点的下标值，在中序遍历里的
        int index = map.get(qian[pre_ix]); // index 就是根节点的坐标,pre_ix 是前序的坐标
        TreeNode root = new TreeNode(qian[pre_ix]);
        // 根据中序遍历 根节点左右的元素，往根节点左右子节点上添加值
        pre_ix++;
        root.left = helperTree(left,index);
        root.right = helperTree(index+1,right);

        return root;
    }

}
