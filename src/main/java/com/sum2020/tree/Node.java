package com.sum2020.tree;

import java.util.List;

/**
 * @author gzd
 * @date 2020/7/10 下午10:15
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
