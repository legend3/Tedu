package day05;

import java.util.List;

/**
 * CLassName: leetcodes/MySingleList
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/7/27 1:18
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/7/27 1:18      LEGEND        1.0         1.0 Version
 */
//单链表的实现
/*Ctrl + R 选中类中相同的变量名称然后，改名*/
public class MySingleList {
    public int val;
    //内部类如果是static的，生成对象的时候是不依赖于外部类对象的,
    //不加static，生成对象的时候依赖于外部类对象
    static class ListNode {
        public int val;//存储值
        public ListNode next;//存储next域
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;//head引用的是当前列表的头节点

    public void createLink() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        head = listNode1;
        //当这个方法走完，node1，2，3，4....都被回收了，
        //他们都是局部变量
    }

    //遍历打印链表
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //从指定位置开始打印链表
    public void display(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //查找是否包含关键字key，是否在单链表中
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) return true;
            cur = cur.next;
        }
        return false;
    }
    //得到单链表的长度
    public int size() {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    //头插法
    public void addFirst(int data){
        ListNode listNode = new ListNode(data);
        listNode.next = head;
        head = listNode;
    }
    //尾插法(考虑如果当前链表没有节点)
    public void addLast(int data) {
        ListNode listNode = new ListNode(data);
        if (head == null) {
            head = listNode;
            return;//不要忘了return
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = listNode;
    }
    //指定下标位置插入节点
    public void addIndex(int index, int data) throws Exception {
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode listNode = new ListNode(data);
        ListNode cur = findIndexSubOne(index);//cur走到下标的前一个位置
        listNode.next = cur.next;
        cur.next = listNode;
    }
    //找到index-1位置的节点的地址
    private ListNode findIndexSubOne(int index) {
        ListNode cur = head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    private void checkIndex(int index) throws Exception {
        if (index < 0 || index > size()) {
//            throw new ListIndexOutOfException("下标位置不合法！");
            throw new Exception("下标位置不合法！");
        }
    }

    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
    }
}