package com.sum2018.hash;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author gzd
 * @date 2019/6/21 下午3:54
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 *
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 *
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 *
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 *
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 *
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 *
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 *
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 *
 *
 * 思路：参考已有的集合结构 HashSet
 */
public class RandomizedSet_380 {
    private Set<Integer> set ;
    /** Initialize your data structure here. */
    public RandomizedSet_380() {
        this.set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.contains(val)){
            return false;
        }else{
            set.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (set.contains(val)){
            set.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (set.size() == 0){
            return 0;
        }
        Integer[] data = set.toArray(new Integer[0]);
        int index = (int) (Math.random()*set.size());
        return data[index];

    }

    public static void main(String[] args) {

        RandomizedSet_380 randomizedSet = new RandomizedSet_380();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.remove(2);
        randomizedSet.insert(5);
        randomizedSet.insert(6);
        System.out.println(randomizedSet.getRandom());
    }
}

