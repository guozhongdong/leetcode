package com.gzd.cache;

/**
 * @author gzd
 * @date 2019/7/19 上午10:23
 * 缓存接口
 */
public interface Cache<K,V> {

    /**
     * 返回一个最新值
     * */
    V get(K key);
    /**
     *
     * 返回一个旧值 V
     * */
    V put(K key,V value);
    /**
     *
     * 返回一个原始值 V
     * */
    V remove(K v);
    /**
     *
     * 清理所有的entry
     * */
    void clear();

    /**
     *返回最大内存大小
     *
     * */
    int getMaxMemroySize();

    /**
     * 返回当前内存大小
     *
     */
    int getMemorySize();
}
