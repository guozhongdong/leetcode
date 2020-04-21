package com.sum2020.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzd
 * @date 2020/4/21 下午10:00
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 * 思路：深度优先搜索，加序列化，也就是把每个根节点对应的子树保存到 map中
 * 如上，应该保存
 * ("4,#,#")
 * ("2,4,#")
 * 之后通过map 的key判断 相同的个数
 *
 */
public class FindDuplicateSubtrees_652 {

    Map<String,Integer> map ;
    Map<String,Integer> trees ;
    Map<Integer,Integer> count ;
    List<TreeNode> list;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left.left = new TreeNode(4);

        //System.out.println(new FindDuplicateSubtrees_652().findDuplicateSubtrees(root));
        System.out.println(new FindDuplicateSubtrees_652().findDuplicateSubtrees2(root));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        collect(root);
        System.out.println(map);
        return list;
    }

    public String collect(TreeNode root){

        if (root == null){
            return "#";
        }
        String key = root.val +","+ collect(root.left)+"," + collect(root.right);
        if (map.containsKey(key)){
            map.put(key,map.get(key)+1);
        }else{
            map.put(key,1);
        }
        if (map.get(key) == 2){
            list.add(root);
        }
        return key;
    }

    // 解法二，将字符创的边界，换成数字的拼接，序列化的时候可能耗时更短些
    int t;
    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        t = 1 ;
        count = new HashMap<>();
        trees = new HashMap<>();
        list = new ArrayList<>();
        collect2(root);
        System.out.println(count);
        return list;
    }

    public int collect2(TreeNode root){

        if (root == null){
            return 0;
        }
        String key = root.val +","+ collect2(root.left)+"," + collect2(root.right);
        int uid = trees.computeIfAbsent(key,x-> t++);
        count.put(uid,count.getOrDefault(uid,0)+1);
        if (count.get(uid) == 2){
            list.add(root);
        }
        return uid;
    }
}
