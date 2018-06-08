package com.primary.math;

import java.util.HashMap;

/**
 * @author gzd
 * @create 2018-06-08 14:09
 * @desc
 **/
public class RomanToInt {



    public static void main(String[] args){
        int num = new RomanToInt().romanToInt("MCMXCIV");
        System.out.println(num);
    }

    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len = s.length();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result = map.get(s.charAt(len - 1));
        int pivot = result;
        for (int i = len - 2; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr >= pivot) {
                result += curr;
            } else {
                result -= curr;
            }
            pivot = curr;
        }

        return result;
    }
}
