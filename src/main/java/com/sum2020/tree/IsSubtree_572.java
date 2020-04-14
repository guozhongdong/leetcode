package com.sum2020.tree;

/**
 * @author gzd
 * @date 2020/4/14 下午
 * 另一个树的子树-572
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 思路：直接先序遍历，把两个结果集，拼成两个字符串
 * 直接比较字符串
 */
public class IsSubtree_572 {



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);

        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(2);

          String str = traverse(treeNode,true);

          String str1 = traverse(treeNode1, true);

        System.out.println(str.indexOf(str1) > 0);
        System.out.println(new IsSubtree_572().isSubtree2(treeNode,treeNode1));

    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String str = traverse(s,true);

        String str1 = traverse(t, true);
        return str.indexOf(str1) > 0;
    }
    /**
     * 第一种解法：先序遍历树
     * */
    public static String traverse(TreeNode s,boolean flag){
        if (s == null){
            if (flag){
                return "lnull";
            }else{
                return "rnull";
            }

        }
        System.out.println(s.val);
        return  "#"+s.val + "#" + traverse(s.left,true) + "#" + traverse(s.right,false);

    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        return traves(s,t);
    }

    public boolean traves(TreeNode s, TreeNode t){
        return s !=null &&(compare(s,t) ||  traves(s.left,t) || traves(s.right,t));
    }
    /**
     *
     * 第二种解法：比较两个节点是否相等
     *
     * 这块是我本意的思路，这两个节点的比较都作出了判断，但是对于他们的子节点判断，绕进去了，还在一层一层的加if判断，
     * 没有相当这个方法可以再次递归
     * */
    public boolean compare(TreeNode s,TreeNode t){
        if (s == null && t == null){
            return true;
        }else if (s == null || t == null){
            return false;
        }
        return s.val == t.val && (compare(s.left,t.left) && compare(s.right,t.right));
    }
}
