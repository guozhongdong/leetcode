package com.sum2018.tree;

/**
 * @author gzd
 * @date 2019/8/21 上午11:09
 * 阿里关于 类加载顺序的面试题
 */
public class JavaTest {

    public static int k = 0;
    public static JavaTest t1 = new JavaTest("t1");
    public static JavaTest t2 = new JavaTest("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("构造块");
    }
    static {
        print("静态块");
    }

    public JavaTest(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String args[]) {
        JavaTest t = new JavaTest("init");
    }



}
