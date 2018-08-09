package com.medium.sortAndsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author gzd
 * @create 2018-08-09 13:47
 * @desc 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 思路：先把给定的集合区间排序，之后进行判断比较 end 和 start
 *
 **/
public class Merge {

    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        Interval interval = new Interval(1,4);
        Interval interval1 = new Interval(2,6);
        //Interval interval2= new Interval(8,10);
        //Interval interval3 = new Interval(15,18);
        intervals.add(interval);
        intervals.add(interval1);
        //intervals.add(interval2);
        //intervals.add(interval3);
        List<Interval> result = new Merge().merge(intervals);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).start+" "+ result.get(i).end);
        }
        System.out.println(result);
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() < 1){
            return result;
        }
        // 先对区间进行排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        /*
        * 遍历所有元素
        * */
        Interval pre = null;
        for (Interval item : intervals){
            // 如果开始元素的end值小于 后一个元素的start的值，则属于正常情况，直接添加即可
            if (pre == null || pre.end < item.start){
                result.add(item);
                pre = item;
                System.out.println(pre.start+ " " + pre.end);
            }else if (pre.end < item.end){ // 如果后一个元素的start 值在 上一个元素的区间内

                pre.end = item.end;
            }
        }
        return result;
    }

}
