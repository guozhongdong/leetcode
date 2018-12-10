package com.byteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author gzd
 * @create 2018-12-10 21:28
 * @desc 简化路径
 * 说明：给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * 例如，
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * 边界情况:
 *
 * 你是否考虑了 路径 = "/../" 的情况？
 * 在这种情况下，你需返回 "/" 。
 * 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
 * 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 * ===================================================================
 * 思路：判断最后一个字符 "/" 后面是否还有路径，-----------第一想法是错误的，没有读懂题意，忽略了是unix的路径，
 *      主要是要排出几个特殊的字符 ".",".."，这几个特殊在系统的意义
 * 思路2：用split("/") 拆分，得到数组,使用栈结构，入栈和出栈，如果是.的话，不做处理，不入栈，是".."的话，根据unix的怒路结构，
 *         回退上一个目录，则将上一级目录出栈，最后保留最终的一个结果
 *
 **/
public class SimplifyPath {

    public static void main(String[] args){
        String s = new SimplifyPath().simplifyPath("/..");
        System.out.println(s);
    }
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        //String str1 = strs[0];
        for (int i = 0; i < strs.length ; i++) {
            if (!stack.isEmpty() && "..".equals(strs[i])){
                stack.pop();
            } else if (!".".equals(strs[i]) && !"".equals(strs[i]) && !"..".equals(strs[i])){
                stack.push(strs[i]);
            }
        }
        List<String> list =new ArrayList<>(stack);
        // join函数的使用
        return "/"+String.join("/",list);
    }
}
