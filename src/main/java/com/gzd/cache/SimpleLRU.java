package com.gzd.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gzd
 * @date 2019/7/23 上午10:27
 */
public class SimpleLRU<K,V> extends LinkedHashMap<K,V> {

    public static final int CAPACITY = 100;

    private int limit;
    public SimpleLRU(){
        this(CAPACITY);
    }

    public SimpleLRU(int limit){
       super(limit,0.75f,true);
       this.limit = limit;
    }


    public V getOne(K key) {
        return get(key);
    }

    public V save(K key,V value) {
        return put(key,value);
    }

    public boolean exists(K key){
        return containsKey(key);
    }
    /**
     * 重写LinkedHashMap内部判断 LRU的逻辑方法，返回true 在删除最近最少使用的。
     * */
    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > limit;
    }


    public static void main(String[] args) {
        SimpleLRU simpleLRU = new SimpleLRU(3);
        simpleLRU.put("1","1");
        simpleLRU.put("2","2");
        simpleLRU.put("3","3");
        simpleLRU.put("4","4");
        System.out.println(simpleLRU);
        System.out.println("访问一个元素："+simpleLRU.get("3"));
        System.out.println(simpleLRU);
        System.out.println("在新加一个元素"+simpleLRU.save("5","5"));
        System.out.println(simpleLRU);
    }
}
