package com.tencent;

/**
 * @author gzd
 * @date create in 2019/1/24 20:23
 * 最长回文字符串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 思路：中心扩散法，分为单核回文和双核回文，即子串一个是计计数位的，一个是计偶数位的
 *
 *
 **/
public class LongestPalindrome {
    private int maxLen = 0;
    private String sub = "";
    public static void main(String[] args){
        String str = "babad";
        String result = new LongestPalindrome().longestPalindrome(str);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }
        String longest = "";
        String subStr = "";
        for (int i = 0; i < s.length()-1 ; i++) {
            subStr = findLongestPalindrome(s,i,i);
            if (subStr.length() > longest.length()){
                longest = subStr;
            }
            subStr = findLongestPalindrome(s,i,i+1);
            if (subStr.length() > longest.length()){
                longest = subStr;
            }
        }
        return longest;
    }

    public String  findLongestPalindrome(String s,int low,int high){

        while (low >= 0 && high <= s.length()-1 && s.charAt(low) == s.charAt(high)){
                low --;
                high++;
        }
        return s.substring(low+1,high);
    }
}
