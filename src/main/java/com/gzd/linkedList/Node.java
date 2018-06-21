package com.gzd.linkedList;

/**
 * @author gzd
 * @create 2018-06-17 10:13
 * @desc
 **/
public class Node {

    public int data; //每个节点的数据
    public Node next; //每个节点的连接

    public Node(int data){
        this.data = data;
    }

    public void add(int data){
        if (this.next == null){
            this.next = new Node(data);
        }else{
            this.next.add(data);
        }
    }

    public void del(int data){
        if (this.next.data == data){
            this.next = this.next.next;
        }else{
            this.next.del(data);
        }
    }

    public void print(){
        if (this.next != null){
            System.out.print("-->"+this.next.data);
            this.next.print();
        }
    }
}
