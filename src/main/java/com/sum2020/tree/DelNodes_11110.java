package com.sum2020.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author guozhongdong
 * @Description:  删点成林
 * @date 2020/7/30
 *
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * 提示：
 *
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 *
 *
 * 每个节点的值都不同，
 * 思路:为了方便查询，将数组的值先放到set集合中，然后后序遍历二叉树，
 * 从最底层的节点开始对比，如果对上了，则把这个节点置位空，
 * 如果不是叶子结点对上，因为是后续遍历，它的子节点肯定是已经遍历过的，则需要把它的不为空的子节点 放到结果集中。
 *
 */
public class DelNodes_11110 {


    List<TreeNode> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] nums = {3,5};
        List<TreeNode> res = new DelNodes_11110().delNodes(root,nums);

        System.out.println(res);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null){
            return new ArrayList<>();
        }

        //便于后续计算是否存在
        for (int i : to_delete) {
            set.add(i);
        }
        if (!set.contains(root.val)){
            result.add(root);
        }
        dfs(root);
        return result;
    }

    /**
     *
     * 后序遍历的思想很重要，
     * 从底层遍历到上一层， 如果在里面 将当前节点置位 空，因为是从下到上遍历，所以不用考虑parent节点
     * */
    public TreeNode dfs(TreeNode root){
        if (root == null){
            return null;
        }
        // 开始遍历,获取最左边的节点
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (set.contains(root.val)){
            if (root.left != null){
                result.add(root.left);
            }
            if (root.right != null){
                result.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
