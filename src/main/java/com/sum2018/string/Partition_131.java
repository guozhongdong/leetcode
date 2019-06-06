package com.sum2018.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @date 2019/6/5 下午8:13
 * 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *  思路：回溯法，动态规划
 *  参考题解：先判断前一个子串是否满足回文，之后判断后面的是否满足回文，满足之后将这个子串添加到列表中，
 *  之后，后面的进行递归查询。
 */
public class Partition_131 {

    public static void main(String[] args) {
        String str = "nhg";

        System.out.println(new Partition_131().partition("abba"));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> str = new ArrayList<>();
        this.helper(s,list,str);
        return list;
    }

    private void helper(String s,List<List<String>> list,List<String> str){

        int len = s.length();
        if (len ==0){
            List<String> temp = new ArrayList<>(str);
            list.add(temp);
            return;
        }
        for (int i = 1; i <= len ; i++) {
            String pre = s.substring(0,i);
            String post = s.substring(i);
            if (this.isHuiWen(pre)){
                str.add(pre);
                this.helper(post,list,str);
                str.remove(str.size()-1);
            }
        }


    }

    private boolean isHuiWen(String str){

        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
