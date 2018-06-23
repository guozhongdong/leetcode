package com.primary.other;

import java.util.Stack;

/**
 * @author gzd
 * @create 2018-06-23 8:46
 * @desc:有效的括号
 * 思路：利用栈的出栈入栈，最终如果栈内还有值，说明返回false
 **/
public class EffectiveBracket {
    public static void main(String[] args){
        boolean flag = new EffectiveBracket().isValid("{[(])}");
        System.out.println(flag);
    }
    public boolean isValid(String s) {
        //
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){ //如果是左括号则入栈
                stack.push(chars[i]);
                System.out.println(stack);
            }else{
                if (stack.isEmpty()){ // 等于空意味着没有 左括号，不成立
                    return false;
                }
                System.out.println(stack.peek());
                System.out.println(chars[i]);
                if ((stack.peek()=='(' && chars[i] == ')') || (stack.peek()=='[' && chars[i] == ']') || (stack.peek()=='{' && chars[i] == '}')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.size()== 0 ? true:false;
    }
}
