package com.sum2020.tree;

import java.util.*;

/**
 * @author gzd
 * @date 2020/7/11 下午12:04
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 *  
 *
 * 示例：
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 *
 *提示：
 *
 * 1 <= N <= 20
 *
 * 通过率吓人，而我没想出来
 *
 * N 个节点
 * 左节点FBT(X)，就可以构建左子树，
 * 右节点FBT(N-1-X) 构建右子树
 *
 * 得好好理解，暂时不懂
 *
 */
public class AllPossibleFBT_894 {

    List<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {
        new AllPossibleFBT_894().allPossibleFBT(7);
    }

    Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }

}
