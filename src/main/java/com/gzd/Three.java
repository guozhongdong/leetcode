package com.gzd;

import java.util.HashMap;

/**
 * @author gzd
 * @create 2018-05-25 22:24
 * @desc 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 解题思路：从前往后遍历，例如第一个往后找，找到相等的之后返回，从第二个往后走
 **/
public class Three {

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        // jskjsfs
        int res = 0;
        int len = 0;
        int start = 0;

        for (int i = 0; i < s.length() ; i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start){
                start = map.get(s.charAt(i)) + 1 ; //如果匹配重复的字符，则把statt重置为 第一次出现重复的那个字符的下一个字符
            }
            len = i-start+1;
            map.put(s.charAt(i),i);
            res = Math.max(res,len);

        }

        return res;
    }
    public static void main(String[] args){
        int s = lengthOfLongestSubstring("jskjsfs");
        System.out.println(s);
    }
}
