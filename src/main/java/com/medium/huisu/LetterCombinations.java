package com.medium.huisu;

import java.util.*;

/**
 * @author gzd
 * @create 2018-07-17 21:15
 * @desc  电话号码的字母组合
 *使用回溯算法 （暂时没太明白题意）
 **/
public class LetterCombinations {

    public static void main(String[] args) {

        List<String > lsit = new LetterCombinations().letterCombinations("23");
        System.out.println(lsit);
    }

    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<String>();
        if (digits.length() == 0) {
            return list;
        }
        backtracking("", digits, 0, list);//回溯
        return list;

        /*Map<Integer,String> map = new HashMap<>();
        map.put(0,"");
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"stu");
        map.put(9,"wxyz");

        List<String> list = new ArrayList<>();
        if (digits.length() == 0){
            return list;
        }
        Queue<StringBuilder> queue = new LinkedList<>();//队列
        queue.add(new StringBuilder());//先在队列中添加一个新的空字符串
        for (int i = 0; i < digits.length() ; i++) {
            int limitSize = queue.size();
            if (digits.charAt(i) == '0' || digits.charAt(i) == '1'){
                continue;
            }
            int tar = digits.charAt(i) - '0';
            int j = 0;
            while (!queue.isEmpty() && j < limitSize){//循环j将limitsize个元素依次出队列
                StringBuilder stringBuilder1 = queue.poll();//每次将队列头一个stringBuilder出队列
                for (char x: map.get(tar).toCharArray()){//循环每一个数字对应的字母，依次加入到队列中
                    StringBuilder tmp = new StringBuilder(stringBuilder1);//获得每一个出对列的stringBuilder，并将后面的字母append到后面
                    tmp.append(x);
                    queue.add(tmp);//将stringBuilder加入到队列中
                }
                ++j;
            }

        }
        while (!queue.isEmpty()){
            list.add(queue.poll().toString());//依次将队列中的字符串加入到结果集中
        }

        *//*String s1 = digits;

        for (int i = 0; i < s1.length() ; i++) {
            System.out.println(s1.charAt(i));
            list.add(String.valueOf(map.get(String.valueOf(s1.charAt(i)))));
        }*//*

        System.out.println(list);
        return list;*/
    }


    public static void backtracking(String s, String digits, int flag, List<String> list) {
        String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (flag >= digits.length()) {
            //如果已经遍历完所有输入的数字，说明已经到达底部，需要向上溯源。
            list.add(s);//到达底部说明已经是完整的一个结果，则将此次结果添加到结果集中
            return;//返回，向上回溯
        }
        String chars = strings[digits.charAt(flag) - '0'];
        for (int i = 0; i < chars.length(); i++) {//遍历一个数字对应的所有字母

            backtracking(s + chars.charAt(i), digits, flag + 1, list);//将当前字符加到s上并将flag+1循环下一个数字的字母
        }

    }
}