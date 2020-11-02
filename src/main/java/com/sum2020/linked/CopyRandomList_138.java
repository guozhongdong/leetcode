package com.sum2020.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guozhongdong
 * @date 2020/11/2 19:52
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 *
 * 随机节点开始没理解是什么意思，随机指向的节点，可能存在也可能不存在，存在的话，就创建一个新的对应上，
 * 如果next 指向一个新创建的节点，就无需创建 了。
 *
 *
 *  后续理解节点的对象，创建过后就无需再重新创建，next节点或者random节点 直接引用即可
 *

 */
public class CopyRandomList_138 {

    Map<Node,Node> visited = new HashMap<>();

    public static void main(String[] args) {
        Node node = new Node(7);


        node.next = new Node(13);
        node.next.random = new Node(0);


        node.next.next = new Node(11);
        node.next.next.random = new Node(4);

        node.next.next.next = new Node(10);
        node.next.next.next.random = new Node(2);

        new CopyRandomList_138().copyRandomList(node);

    }

    /*public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node newHead = new Node(head.val);
        if (head.random == null){
            newHead.random = null;
        }else{
            newHead.random = new Node(head.random.val);
        }
        newHead.next = copyRandomList(head.next);

        return newHead;
    }*/

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node oldNode = head;

        // Creating the new head node.
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned.
        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }


    /**
     * 创建一个新的节点
     * */
    public Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the dictionary
                return this.visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new Node(node.val));
                return this.visited.get(node);
            }
        }
        return null;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
