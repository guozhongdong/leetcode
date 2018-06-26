package com.medium.array;

import java.util.*;

/**
 * @author gzd
 * @create 2018-06-26 12:58
 * @desc:字谜分组，所有输入均为小写字母，不考虑答案的输出顺序
 * 思路：遍历数组，计算每个字符的  // 不可行
 * 先将每一个字符串的 字符 排序，异位的最终会变成 相同的一组 字符串
 **/
public class GroupAnagrams {

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = {"",""};
        new GroupAnagrams().groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length ==0){
            return new ArrayList<List<String>>();
        }
        // 定义一个结果list
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            char[] chr = str.toCharArray();
            // 对字符进行排序，异位的会变成相同顺序的字符
            Arrays.sort(chr);
            // 将排序后的字符 组装成相同的字符串，之后放到map中，
            String s = String.valueOf(chr);
            if (!hashMap.containsKey(s)){ // 判断 当前字符串在不在 map中，不在的话，新加一个 以字符串为
                // key ,新List 未 value 的结果集，
                hashMap.put(s,new ArrayList<>());
            }
            // 如果map里包含 这key，则表示已经有相同的，将未排序的字符串，加到key中，
            hashMap.get(s).add(str);
        }
        for (HashMap.Entry<String,List<String>> map : hashMap.entrySet()){
            list.add(map.getValue());
        }
       //list = (List<List<String>>) hashMap.values();
        //System.out.println(hashMap.values());
        System.out.println(list);
        return list;

    }
}
