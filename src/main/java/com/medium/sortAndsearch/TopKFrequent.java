package com.medium.sortAndsearch;

import java.util.*;

/**
 * @author gzd
 * @create 2018-07-16 21:38
 * @desc 前K个高频元素
 * 思路：利用堆排序
 **/
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        new TopKFrequent().topKFrequent(nums, 2);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        List<Integer> list = new ArrayList();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> map : set) {
            pq.add(map);
        }
        for (int i = 0; i < k; i++) {
            list.add(pq.poll().getKey());
        }
        System.out.println(list);
        System.out.println(hashMap);
        return list;
    }
}
