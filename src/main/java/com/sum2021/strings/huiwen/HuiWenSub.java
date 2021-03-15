package com.sum2021.strings.huiwen;

/**
 * @author guozhongdong
 * @date 2021/3/15 19:49
 * <p>
 * 给定一个字符串，求它的最长回文子串的长度。
 * <p>
 * O(N)解法 暂时没看懂
 */
public class HuiWenSub {

    public static void main(String[] args) {
        String str = "abcdcbe";
        System.out.println(new HuiWenSub().reverseSubString(str));
    }

    /**
     * 求最大的回文子串
     * 思路：从某一个字符开始，往前后找，判断前后两个字符是否相等
     */
    public int reverseSubString(String str) {
        if (str == null) {
            return 0;
        }
        int n = str.length();
        int max = 0;
        // i代表中心点的字符
        for (int i = 0; i < n; i++) {
            int c = 0;
            //字符奇数判断
            for (int j = 0; ((i - j) >= 0 && (i + j) < n); j++) {
                if (str.charAt(i - j) != str.charAt(i + j)) {

                    break;

                }
                c = j * 2 + 1;
            }
            if (c > max) {
                max = c;
            }

            //字符偶数判断
            for (int j = 0; ((i - j) >= 0 && (i + j + 1) < n); j++) {
                if (str.charAt(i - j) != str.charAt(i + j + 1)) {

                    break;

                }
                c = j * 2 + 2;
            }
            if (c > max) {
                max = c;
            }
        }
        return max;
    }

}
