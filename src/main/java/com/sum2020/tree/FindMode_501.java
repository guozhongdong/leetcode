package com.sum2020.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzd
 * @date 2020/4/17 下午9:02
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 思路：先用第三方空间做出来，这里使用map，可是树上的数，value是 个数
 * 遍历二叉树
 * 方法2：不使用额外空间
 *  理解题目中的提示，
 *
 */
public class FindMode_501 {


    Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        //new FindMode_501().findMode(root);
        int[] nums = new FindMode_501().findMode2(root);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    public int[] findMode(TreeNode root) {

        traverse(root);
        int max = 0;

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> mk:map.entrySet()){
            if (mk.getValue() > max){
                count = mk.getValue();
                max = mk.getValue();
            }
        }
        for (Map.Entry<Integer,Integer> mk:map.entrySet()){
            if (mk.getValue() == count){
               list.add(mk.getKey());
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }

    public void traverse(TreeNode root){

        if (root == null){
            return ;
        }
        if (map.containsKey(root.val)){
            map.put(root.val,map.get(root.val)+1);
        }else{
            map.put(root.val,1);
        }
        traverse(root.left);
        traverse(root.right);

    }
    private List<Integer> items;
    private int maxCount;
    private int curCount;
    private TreeNode pre;


    public int[] findMode2(TreeNode root) {

        // 中序遍历，是个升序遍历，但还是使用了额外空间，之后在对list进行求众数
        if (root == null)
            return new int[0];
        items = new ArrayList<>();
        // 这里设置为1是因为 在递归中 BST中最左边的结点被跳过了，作为初状态 该结点值出现一次，记录的出现最多次数一开始也为1
        maxCount = 1;
        curCount = 1;
        traverse2(root);
        // 最右端结点的处理，从递归中看，最后一个结点与前一个结点相等只更新了curCount的值；不相等则只考虑到倒数第二个结点。
        if(curCount > maxCount)
            return new int[]{pre.val};
        if(curCount == maxCount)
            items.add(pre.val);
        int[] res = new int[items.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = items.get(i);
        return res;
    }


    public void traverse2(TreeNode x){


        if (x == null) return;
        traverse2(x.left);
        if(pre != null){
            if(x.val != pre.val){ // 说明上一个值的结点数量已经统计完成 要看出现次数的情况
                if(curCount > maxCount){ // 出现次数更多，清空之前的出现少的数，更新最大出现次数
                    maxCount = curCount;
                    items.clear();
                    items.add(pre.val);
                }
                else if(curCount == maxCount){ // 不止一个众数
                    items.add(pre.val);
                }
                curCount = 1; // 当前值与上一个结点值不同，重置计数
            }
            else curCount++; // 当前值与上一个结点值相同，当前值的出现次数增加。
        }
        pre = x;
        traverse2(x.right);
    }

}
