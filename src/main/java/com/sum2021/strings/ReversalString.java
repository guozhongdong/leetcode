package com.sum2021.strings;


/**
 * @author guozhongdong
 * @date 2021/1/12 20:08
 *
 *
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，
 * 要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 翻转
 *
 * 一、暴力解法
 * 时间复杂度 O(mn)
 *
 * 二、先翻转，后拼接
 *
 * 时间复杂度O(n)
 * 练习
 */
public class ReversalString {

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(new ReversalString().toRevers(str, 2));
        System.out.println(new ReversalString().toRevers2(str, 2));

        StringBuilder sb = new StringBuilder("abcdef");
        sb.reverse();
    }

    /**
     * 移位
     * */
    public String revers(char[] chs,int num){


        char ch1 = chs[0];
        for (int i = 1; i < num; i++) {
            chs[i-1] = chs[i];
        }
        chs[num-1] = ch1;

        return new String(chs);
    }

    public String toRevers(String str ,int n){
        String result = str;
        while(n > 0){
            result = revers(result.toCharArray(),result.length());
            n--;
        }
        return result;
    }


    /**
     *  求反
     *  X= "abc"
     *  Y= "def"
     *  X^T = "cba"
     *  Y^T = "fed"
     *
     *  (X^TY^T)^T = defabc;
     *
     * */
    public String toRevers2(String str,int m){

        String result = str;
        int n = result.length();
        m %= n;
        result = revers2(result.toCharArray(),0,m-1);
        result = revers2(result.toCharArray(),m,n-1);
        result = revers2(result.toCharArray(),0,n-1);


        return result;
    }

    /**
     * 部分翻转
     * */
    public String revers2(char[] chs,int from  ,int to){

        //前后对调一下
       while (from < to){
            char t = chs[from];
            chs[from++] = chs[to];
            chs[to--] = t;
       }
       return new String(chs);
    }

}
