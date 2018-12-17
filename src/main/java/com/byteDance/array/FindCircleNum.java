package com.byteDance.array;

/**
 * @author gzd
 * @create 2018-12-17 21:30
 * @desc 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
 * 表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 思路：1、遍历循环，找出i和j不相等的，判断结果是否为1，
 *  正解思路：深度优先遍历，难点在于找这人朋友的朋友，
 *  学习深度优先遍历------Depth-First Search
 *  https://baike.baidu.com/item/%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E9%81%8D%E5%8E%86/9796166
 *  百度百科：假设给定图G的初态是所有顶点均未曾访问过。在G中任选一顶点v为初始出发点(源点)，
 *  则深度优先遍历可定义如下：首先访问出发点v，并将其标记为已访问过；
 *  然后依次从v出发搜索v的每个邻接点w。若w未曾访问过，则以w为新的出发点继续进行深度优先遍历，
 *  直至图中所有和源点v有路径相通的顶点(亦称为从源点可达的顶点)均已被访问为止。若此时图中仍有未访问的顶点，
 *  则另选一个尚未访问的顶点作为新的源点重复上述过程，直至图中所有顶点均已被访问为止。
 **/
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int res = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                //没有访问到，就把当前的组+1，并把可以包含在朋友圈的所有的有关系的好友标记出来
                res++;
                dfs(M, visited, i);
            }
        }
        return res;

    }
    private void dfs(int[][] M, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                dfs(M, visited, j);//在去找这个好友的好友
            }

        }
    }

    public static void main(String[] args){

        int[][] nums = {{1,1,0},{1,1,1},{0,1,1}};
        int n =  new FindCircleNum().findCircleNum(nums);
        System.out.println(n);
    }

}
