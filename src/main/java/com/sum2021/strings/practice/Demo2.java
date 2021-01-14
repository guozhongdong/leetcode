package com.sum2021.strings.practice;

/**
 * @author guozhongdong
 * @date 2021/1/14 20:42
 *
 * 2、编写程序，在原字符串中把字符串尾部的m个字符移动到字符串的头部，
 * 要求：长度为n的字符串操作时间复杂度为O(n)，
 * 空间复杂度为O(1)。 例如，原字符串为”Ilovebaofeng”，m=7，输出结果为：”baofengIlove”。
 *
 * x == Ilove X^T== evolI
 *
 * Y == baofeng  Y^T = gnefoab
 *
 * X^TY^T = evolIgnefoab
 *
 * (X^TY^T)^T baofengIlove
 *
 * result = y + x;
 */
public class Demo2 {

    public static void main(String[] args) {
       String result =  new Demo2().reversString2("Ilovebaofeng",7);
        System.out.println(result);
    }
    /**
     * 暴力拆解
     * */
    public String reversString(String str,int m){
        char[] res = new char[str.length()];
        char[] cs1 = getChars(str.toCharArray(),0,str.length()-m);
        char[] cs2 = getChars(str.toCharArray(),str.length()-m,str.length());
        for (int i = 0; i < cs2.length; i++) {
            res[i] = cs2[i];
        }
        for (int i = 0; i+cs2.length < res.length; i++) {
            res[i+cs2.length] = cs1[i];
        }
        System.out.println();
        return new String(res);
    }

    public char[] getChars(char[] chs ,int start,int end){
        char[] cs = new char[end-start];
        for (int i = 0; start+i < end; i++) {
            cs[i] = chs[start+i];
        }
        return cs;
    }


    /**
     * 三步曲
     * x = Ilove x^T = evolI
     * y = baofeng   y^T = gnefoab
     *
     * xy ^t = baofengIlove
     * */
    public String reversString2(String str,int m){
       String str1 = str;
       int n = str.length() - m;
        str1 = revers2(str1.toCharArray(),0,n-1);
        str1 = revers2(str1.toCharArray(),n,str.length()-1);
        str1 = revers2(str1.toCharArray(),0,str.length()-1);
        return str1;
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
