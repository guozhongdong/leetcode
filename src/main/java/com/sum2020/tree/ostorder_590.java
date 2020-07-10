package com.sum2020.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gzd
 * @date 2020/7/10 下午10:14
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 通过次数27,672提交次数37,417
 *
 * 思路：树的遍历指定是递归，
 * 后序遍历是 先遍历子节点，在遍历根节点
 */
public class ostorder_590 {
    List<Integer> result = new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }
        if (root.children.size() > 0){
            for (Node child : root.children) {
                postorder(child);
            }
        }
        result.add(root.val);
        return result;
    }
    /**
     * 迭代方式
     * 用栈解决，先把每一层的节点都按栈里，根节先放进去，之后之后取出它的值，放到值list里，
     * 取出它的子节点放到栈里，这样栈里就剩子节点的值，继续遍历这个栈，此时遍历的应该是子节点了，再来一轮把子节点的值
     * 放到值list，子节点的子节点，继续放栈里遍历。
     * tip:栈里的节点要从后往前取，才能满足题意，因为栈是先进后出，应该先从栈底取。
     *
     *
     * */
    public List<Integer> postorder1(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            result.addFirst(node.val);
            for (Node child : node.children) {
                stack.addFirst(child);
            }
        }

        return result;
    }
}
