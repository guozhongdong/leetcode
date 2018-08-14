package com.medium.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @create 2018-08-14 21:30
 * @desc 回溯算法
 *  生成括号
 *  给出n 代表生成括号的对数，写出一个函数 使其能够生成所有可能的并且有效的括号组合
 **/
public class GenerateParenthesis {

    public static void main(String[] args){
        List<String> list = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(list);
    }
    /*没太明白题意*/
    public List<String> generateParenthesis(int n) {
        List<String> list = new  ArrayList<>();
        chuli("", list, n, n);
        return list;

    }
    public static void chuli(String s, List<String> list,int left, int right) {
        if (left>right) {
            return;
        }

        if (left>0) {
            chuli(s+"(", list, left-1, right);
        }
        if (right>0) {
            chuli(s+")", list, left, right-1);
        }
        if (left==0&&right==0) {
            list.add(s);
            return;
        }
    }

}
