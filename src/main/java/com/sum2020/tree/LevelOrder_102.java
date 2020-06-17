package com.sum2020.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author guozhongdong
 *
 * @date 2020/6/17
 * 102. 二叉树的层序遍历
 *
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 思路：广度优先搜索
 * 记录每一层到队列中，然后出队列记录每一层的数字.
 * 如root是根节点，先加入到队列中，
 * 1
 * 然后判断队列不为空，之后取出root节点，把root节点的值加入到相应队列中，
 * 之后，如果root 的左节点或者右节点不为空，在加入到队列中，此时队列的值为
 * 2 ，3
 * 同理继续往下遍历

 */
public class LevelOrder_102 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> list = new LevelOrder_102().levelOrder(treeNode);
        System.out.println(list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (queue.size() > 0){
            int size = queue.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node != null){
                    result.add(node.val);
                    if (node.left != null){
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        queue.add(node.right);
                    }
                }

            }
            res.add(result);

        }
        return res;
    }

    public void search(TreeNode root){
        if (root == null){
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        if (root.left != null){
            list.add(root.left);
        }



    }



}
