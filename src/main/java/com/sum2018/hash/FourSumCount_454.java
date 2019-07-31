package com.sum2018.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzd
 * @date 2019/7/30 下午7:48
 *
 * 四数相加 II
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 思路：参考题解
 * 使用hash表+两次循环，计算任意两组的和，记录出现的次数，再计算另外两组出现的相反数。
 * 之后，相加value出现的次数。
 *
 *
 */
public class FourSumCount_454 {

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        int count = new FourSumCount_454().fourSumCount(A,B,C,D);
        System.out.println(count);
        //System.out.println(1^1);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>(500);
        //map.getOrDefault()
        int count = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0;  j< len; j++) {
                int sum = A[i]+B[j];

                map.put(sum,map.getOrDefault(sum,0)+1);

            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0;  j< len; j++) {
                int sum = C[i]+D[j];

                    count += map.getOrDefault(-sum,0);


            }
        }

        return count;
    }
}
