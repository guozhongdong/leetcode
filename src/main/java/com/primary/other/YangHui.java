package com.primary.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @create 2018-06-12 9:10
 * @desc:杨辉三角
 **/
public class YangHui {
    public static void main(String[] args){
        new YangHui().generate(5);
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows >=1 ){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
        }
        if (numRows >= 2){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            result.add(list);
        }
        if (numRows >= 3){
            for (int i = 3; i <= numRows ; i++) {
                List<Integer> list = new ArrayList<>();
                List<Integer> prev = result.get(i-2);
                list.add(1);
                for (int j = 2; j <= i-1; j++) {
                    list.add(prev.get(j-2)+prev.get(j-1));
                }
                list.add(1);
                result.add(list);
            }

        }
        System.out.println(result);
        return result;
    }
}
