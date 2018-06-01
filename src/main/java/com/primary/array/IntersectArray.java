package com.primary.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzd
 * @create 2018-05-30 22:54
 * @desc:重点关注 2018年5月31日09:31:47
 * 思路：创建一个map集合将 nums1 的元素全部放进去，并记录每个元素出现的次数，
 *      之后遍历 nums2，判断在集合中存在不存在，存在的话，将相同的元素添加到list集合，并将map中元素的
 *      次数 -1，之后在遍历list集合
 * 思路2：先将两个数组进行排序，之后各自按照索引去循环遍历，如果第一个索引对应的值相等，放到集合中，且索引各自加加，如果nums1的索引
 *       对应值较大，则将nums2的索引++，直到值相等。
 **/
public class IntersectArray {

    public static void main(String[] args){
        int[] nums1 = {1,3,2,2,3,1};
        int[] nums2 = {3,2};
        int[] temp = new IntersectArray().intersect(nums1,nums2);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length ; i++) {
            Integer value = map.get(nums1[i]);
            map.put(nums1[i],(value == null ? 0 :value)+1);
        }
        for (int i = 0; i < nums2.length ; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0){
                list.add(nums2[i]);
                System.out.println(map);
                map.put(nums2[i],map.get(nums2[i])-1);
                System.out.println(map);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer e : list){
                res[i++] = e;
        }
        return res;
    }
}
