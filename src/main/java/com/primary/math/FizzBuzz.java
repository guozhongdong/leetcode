package com.primary.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @create 2018-06-08 13:33
 * @desc
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 **/
public class FizzBuzz {

    public static void main(String[] args){
       List<String> list =  new FizzBuzz().fizzBuzz(15);
       System.out.println(list);
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            if (i%3 == 0 && i%5 == 0){
                list.add("FizzBuzz");
                continue;
            }
            if (i%3 == 0){
                list.add("Fizz");
                continue;
            }
            if (i%5 == 0){
                list.add("Buzz");
                continue;
            }
            list.add(i+"");
        }

        return list;
    }
}
