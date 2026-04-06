package com.itheima.saunfa;

public class Lianbiao {
    public static void main(String[] args) {
        Node nodefirst = initialize();
  Node prev = null;      // 前驱节点初始化为null
        Node current = nodefirst;   // 当前节点从头节点开始
        Node next = null;       // 用于临时存储下一节点

        while (current != null) {
            next = current.next; // 1. 保存下一节点避免断链
            current.next = prev; // 2. 反转指针：当前节点指向前驱
            prev = current;      // 3. 前驱节点后移
            current = next;      // 4. 当前节点后移
        }

        bianli(prev);

    }

    private static void bianli(Node nodefirst) {
        Node p=new Node();
        p= nodefirst;
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }

    private static Node initialize() {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        return node;
    }
}
class Node{
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
    }

    public Node(){

    }
}
