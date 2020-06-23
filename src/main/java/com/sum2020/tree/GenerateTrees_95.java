package com.sum2020.tree;

import com.sum2020.array.GenerateMatrix_59;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/6/23
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  二叉搜索树
 * 左比中间小，中间比右小
 *
 * 迭代遍历,判断后面一个数适合放到哪边,
 * 递归
 * 1...n  寻找一个中间节点 i，
 * 1...i 都是i 的左节点
 * i...n 都是i的右节点，
 * 分别构建它的左右节点
 *
 */
public class GenerateTrees_95 {

    public static void main(String[] args) {
        List<TreeNode> list = new GenerateTrees_95().generateTrees(3);
        System.out.println(list.size());
    }

    public List<TreeNode>  generate(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }
        if (start == end){
            res.add(new TreeNode(start));
            return res;
        }
        //尝试把每个数字都作为根节点
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftTrees = generate(start,i-1);
            List<TreeNode> rightsTrees = generate(i+1,end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightsTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    res.add(root);
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
       return generate(1,n);

    }
}
