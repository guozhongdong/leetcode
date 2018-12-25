package com.byteDance.dataStructure;

import java.util.Stack;

/**
 * @author gzd
 * @create 2018-12-25 22:09
 * @desc  最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 思路1：使用两个栈，一个栈实现基本功能，一个栈放最小值,====方法1 提交时没有ac成功
 * 思路2：使用一个栈，找一个int类型，存最小值,存元素的时候和取元素的时候，做一个比较
 **/
public class MinStack {

    /* 方法1一
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x){
            s2.push(x);
        }
    }
    //删除栈顶元素
    public void pop() {

        int s = s1.pop();
        if (s == s2.peek()){
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }*/

    // 方法二

    private Stack<Integer> s = new Stack<>();
    int min_val = Integer.MAX_VALUE;
    public MinStack() {

    }
    public void push(int x) {

        if (x <= min_val){
            s.push(min_val);
            min_val = x;
        }
        s.push(x);
    }

    public void pop() {

        if (s.pop() == min_val)
            min_val = s.pop();

    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min_val;
    }
    public static void main(String[] args){
          MinStack obj = new MinStack();
            obj.push(-2);
            obj.push(0);
            obj.push(-3);
            obj.push(8);

            obj.pop();
            obj.pop();
            obj.pop();
            System.out.println(obj.getMin());
           /* System.out.println("");

           System.out.println(obj.top());
           System.out.println(obj.getMin());*/


    }
}
