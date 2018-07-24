package com.medium.linked;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author gzd
 * @create 2018-07-24 13:41
 * @desc 两个队列实现栈
 * 思路： 添加数据的话，都入到队列A,取数据的时候，先判断A中的数据，如果是一个的话，
 * 直接返回A，如果大于1，则把A队列的数据一次放到 B队列中，A中保留一个，
 * 之后再把B中的数据一次 入到 A中，这样A开始剩下的一个元素，就会先出，同理，取第二个数据也是如此操作。
 **/
public class DoubleQueueToStack<T> {

    //创建两个队列
    Queue<T> queue1 = new ArrayDeque<T>();
    Queue<T> queue2 = new ArrayDeque<T>();

    public void push(T t){
        queue1.add(t);
    }

    public T pop(){

        if (queue1.size() <=1 ){
            queue1.poll();
        }else {
            while (queue1.size() > 1){
                queue2.add(queue1.poll());
            }
        }
        System.out.println(queue1);
        System.out.println(queue2);
        while (queue2.size() > 0){
            System.out.println(queue2);
            queue1.add(queue2.poll());
        }
        System.out.println(queue1);
        return queue1.poll();
    }


    public static void main(String[] args){

        DoubleQueueToStack<String> doubleQueueToStack = new DoubleQueueToStack<>();
        doubleQueueToStack.push("12");
        doubleQueueToStack.push("34");
        doubleQueueToStack.push("56");
        doubleQueueToStack.push("78");
        doubleQueueToStack.push("9");
        String s1 = doubleQueueToStack.pop();
        String s2 = doubleQueueToStack.pop();
        System.out.println(s1);
        System.out.println(s2);
    }
}
