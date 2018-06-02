package com.primary.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gzd
 * @create 2018-06-01 22:42
 * @desc:字符串中的第一个唯一字符
 **/
public class FirstUniqChar {

    public static void main(String[] args){
        new FirstUniqChar().firstUniqChar("leelktcoode");
    }
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character, Integer>();

        int temp = s.length()-1;
        for (int i = 0; i < s.length(); i++) {
            Integer value = map.get(s.charAt(i));
            map.put(s.charAt(i),(value ==null ? 0 : value)+1);
        }
        char s1 = '1';
        String s2 = null;
        for (Map.Entry map1:map.entrySet()){
            if (map1.getValue().equals("1")){
                s2  = (String)map1.getKey();
                break;
            }
        }
        System.out.println(s2);
        System.out.println(map);
        return  0 ;

    }
}
