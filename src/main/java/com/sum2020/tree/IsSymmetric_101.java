package com.sum2020.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gzd
 * @date 2020/7/4 下午1:24
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗
 *
 * 思路，递归比较，
 * 主要是检查子树是否相等
 * 引用：设计到比较两个子树的，如判断一个树是不是另一个子树的子集，
 * 判断链表是不是树的子集，都使用这种递归，
 * 推测时，先满足最小结果，在推算全过程。
 *
 *
 */
public class IsSymmetric_101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        System.out.println(new IsSymmetric_101().isSymmetric(root));
        System.out.println(new IsSymmetric_101().isSymmetric1(root));

    }
    public boolean isSymmetric(TreeNode root) {

        return isSub(root,root) ;
    }

    public boolean isSymmetric1(TreeNode root) {

        return check(root,root) ;
    }
    public boolean isSub(TreeNode left,TreeNode right){

        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }

        return left.val == right.val && isSub(left.left,right.right) && isSub(left.right,right.left);
    }

    /**
     *
     * 迭代解法
     * 涉及到迭代，基本上都会用到队列，利用队列的特性，先进先出
     * 设计两个根节点，放到队列，比较它的值，再然后分别把根节点的左右 子树，也放进去，循环比较
     */
    public boolean check(TreeNode left,TreeNode right){

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()){
            left = queue.poll();
            right = queue.poll();
            // 如果两个子树都为空，则肯定是对称的
            if (left == null && right == null){
                continue;
            }
            if ((left == null || right ==null) || left.val != right.val){
                return false;
            }
            queue.offer(left.right);
            queue.offer(right.left);

            queue.offer(left.left);
            queue.offer(right.right);

        }

        return true;
    }
}
