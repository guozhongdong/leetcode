package com.sum2018.string;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @date 2019/6/8 下午1:07
 *
 * 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 *
 * 思路：遍历单词 s，拼成新的子串，判断子串是否在字典中，循环判断，有点递归的感觉
 * 参考网上的案例
 */
public class WordBreak_139 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen1");
        System.out.println(new WordBreak_139().wordBreak("applepenapple", list));
    }
    // 动态规划
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0){
            return false;
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] = dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /*private boolean isDict(String str,List<String> wordDict){
        for (int i = 0; i < wordDict.size(); i++) {
            if (str.equals(wordDict.get(i))){
                return true;
            }
        }
        return false;
    }*/

}
