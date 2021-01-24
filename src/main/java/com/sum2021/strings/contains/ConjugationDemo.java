package com.sum2021.strings.contains;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guozhongdong
 * @date 2021/1/24 15:54
 *
 * 变位词
 *
 * 练习 ，如果短的字符串的顺序不一样，如何判断是否包含
 * 判断两个字符串是否是兄弟字符串  abd和bad
 *
 * 即两个字符串字符一样，顺序不一样
 *
 * 知识点：用hash函数重新计算下标，相同的字符计算的下标肯定是一样的。
 *
 *
 */
public class ConjugationDemo {

    public static void main(String[] args) {

        String str1 = "abd";
        String str2 = "bad";
        System.out.println(new ConjugationDemo().broString(str1, str2));

    }
    /**
     * 记录一个统一的下标
     * 用hash标，下标是根据每个字符计算出来的，
     * */
    public boolean broString(String a,String b){
        Map<Integer,Character> r1 = new HashMap<>();
        Map<Integer,Character> r2 = new HashMap<>();
        if (a.length() != b.length()){
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            r1.put(a.charAt(i)-'A',a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            r2.put(b.charAt(i)-'A',b.charAt(i));
        }

        for (Map.Entry<Integer,Character> result: r1.entrySet()){

            if (!result.getValue().equals(r2.get(result.getKey()))){
                return false;
            }

        }

        return true;
    }
}
