package com.sum2018.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @date create in 2019/6/9 21:16
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 实现：使用基本的集合list，但时间消耗太多，700多毫秒，参考网上用法，
 * 使用Node节点，实现基本的字符查找。
 *
 **/
public class Trie_208 {
    /** Initialize your data structure here. */
    private List<String> list = null;
    public Trie_208() {
        this.list = new ArrayList<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        list.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        return list.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String s : list) {
            if (s.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Trie_208 trie = new Trie_208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("apple"));
    }
}
