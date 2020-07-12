package com.sum2020.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gzd
 * @date 2020/7/12 下午9:04
 *
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 *
 *
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 *
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *  
 *
 * 提示：
 *
 * 1 <= label <= 10^6
 *
 * 先把层数记住，顺序找到，遍历
 *
 * 根据二叉树的性质，求出最左节点+最右节点的和
 * 完全二叉树  下一层节点是当前层的2倍，
 * 2^n-1 + (2^n - 1 )
 * 1层 1 个   左右和 1
 * 2层 2个    2+3
 * 3层 4个    4+7
 * 4层 8个    8+15
 *  又因为是之字型的，所有奇偶层不一样，要反过来，可根据每一层的层和计算
 * 主要是求出 N ，即label的层数
 *
 * Left+Right=2
 * N−1
 *  +(2
 * N
 *  −1)
 *
 * Left+Right = 2^{N-1}+2^N-1=2^{N-1}+2*2^{N-1}-1=3*2^{N-1}-1
 * Left+Right=2
 * N−1
 *  +2
 * N
 *  −1=2
 * N−1
 *  +2∗2
 * N−1
 *  −1=3∗2
 * N−1
 *  −1
 *
 * X=(Left+Right)-Label/2 = 3*2^{N-1}-1 -Label/2
 * X=(Left+Right)−Label/2=3∗2
 * N−1
 *  −1−Label/2
 *
 */
public class PathInZigZagTree_1104 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new PathInZigZagTree_1104().pathInZigZagTree(5));
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        //求出层数
        // log2^n = label  求出n 是解题关键，也是真正的层数，
        int a = (int) (Math.log(label)/Math.log(2));

        while (label > 1){
            result.add(label);
            //按正常的逻辑，label/2 ,就是上一层的节点，但是这个是之字型的，根据每一层的首位和，找出规律求出对称点，也是关键
            //(2^n-1)  + (2^n  -1) - label/2
            label = (int) (Math.pow(2,a) - 1 + Math.pow(2,--a) - label/2);
        }
        result.add(1);
        Collections.reverse(result);
        return result;
    }
}
