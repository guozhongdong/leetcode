package com.gzd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzd
 * @date 2019/8/21 下午9:08
 *
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *
 * 思路：遍历单词数组，判断单词的每个字符是否在 chars中，
 * ============================================
 * 参考网上思路：选择hashmap存放字符出现的次数。
 *
 */
public class CountCharacters_1160 {


    public static void main(String[] args) {
        String[] strs = {"hello","world","leetcode"};
        int num = new CountCharacters_1160().countCharacters_2(strs,"welldonehoneyr");
        System.out.println(num);
    }
    public int countCharacters(String[] words, String chars) {
        int count = 0;

        for (String word : words) {
            String tempChar = chars;
            int tempCount = 0;
            for (int i = 0; i < word.length(); i++) {
                String temp = String.valueOf(word.charAt(i));
                if (tempChar.contains(temp)){
                    tempCount++;
                    tempChar = tempChar.replaceFirst(temp,"");
                }else{
                    tempCount = 0;
                    break;
                }
            }

            count += tempCount;

        }

        return count;
    }


    /**
     * hashMap 解法、
     *
     * */
    public int countCharacters_2(String[] words, String chars) {
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i),map.getOrDefault(chars.charAt(i),0)+1);
        }
        for (int i = 0; i < words.length; i++) {
            HashMap<Character,Integer> tempMap = (HashMap) map.clone();
            boolean flag = true;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (!tempMap.containsKey(word.charAt(j))){
                    flag = false;
                    break;
                }else{
                    if (tempMap.get(word.charAt(j)) >= 1){
                        tempMap.put(word.charAt(j),tempMap.get(word.charAt(j))-1);
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if (flag){
                count += word.length();
            }

        }
        return count;
    }
}
