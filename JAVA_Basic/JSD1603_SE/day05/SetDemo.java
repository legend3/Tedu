package day05;


import org.junit.Test;

import java.util.*;

/**
 * CLassName: day04/SetDemo
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/8/22 0:15
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/8/22 0:15      LEGEND        1.0         1.0 Version
 */
public class SetDemo {
    @Test
    public void test01() {
        //Set 集合存和取的顺序不一致。
        Set hs = new HashSet();
        hs.add("世界军事");
        hs.add("兵器知识");
        hs.add("舰船知识");
        hs.add("汉和防务");
        System.out.println(hs);
        // [舰船知识, 世界军事, 兵器知识, 汉和防务]
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    @Test
    public void test02() {//HashSet
        // Set 集合存和取的顺序不一致。
        Set hs = new HashSet();
        hs.add("世界军事");
        hs.add("兵器知识");
        hs.add("舰船知识");
        hs.add("汉和防务");

        // 返回此 set 中的元素的数量
        System.out.println(hs.size()); // 4

        // 如果此 set 尚未包含指定元素，则返回 true
        boolean add = hs.add("世界军事"); // false
        System.out.println(add);

        // 返回此 set 中的元素的数量
        System.out.println(hs.size());// 4
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    @Test
    public void test03() {//HashSet，使用HashSet存储自定义对象，并尝试添加重复对象（对象的重复的判定）
        HashSet hs = new HashSet();
        hs.add(new Person("jack", 20));
        hs.add(new Person("rose", 20));
        hs.add(new Person("hmm", 20));
        hs.add(new Person("lilei", 20));
        hs.add(new Person("jack", 20));


        Iterator it = hs.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }
    }
    @Test
    public void test04() {
        //问题：现在有一批数据，要求不能重复存储元素，而且要排序。ArrayList 、 LinkedList不能去除重复数据。
        // HashSet可以去除重复，但是是无序。
        //所以这时候就要使用TreeSet了
        TreeSet ts = new TreeSet();
        ts.add("ccc");
        ts.add("aaa");
        ts.add("ddd");
        ts.add("bbb");

        System.out.println(ts); // [aaa, bbb, ccc, ddd]
    }
    @Test
    public void test05() {
        TreeSet ts = new TreeSet();
        ts.add(new Person2("aa", 20, "男"));
        ts.add(new Person2("bb", 18, "女"));
        ts.add(new Person2("cc", 17, "男"));
        ts.add(new Person2("dd", 17, "女"));
        ts.add(new Person2("dd", 15, "女"));
        ts.add(new Person2("dd", 15, "女"));


        System.out.println(ts);
        System.out.println(ts.size()); // 5
    }
    @Test
    public void test06() {
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add(new Book("think in java", 100));
        ts.add(new Book("java 核心技术", 75));
        ts.add(new Book("现代操作系统", 50));
        ts.add(new Book("java就业教程", 35));
        ts.add(new Book("think in java", 100));
        ts.add(new Book("ccc in java", 100));

        System.out.println("ts:" + ts);
    }

class MyComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Book b1 = (Book) o1;
        Book b2 = (Book) o2;

//        System.out.println(b1+" comparator "+b2);
        if (b1.getPrice() > b2.getPrice()) {
            return 1;
        }
        if (b1.getPrice() < b2.getPrice()) {
            return -1;
        }
        return b1.getName().compareTo(b2.getName());
        }
    }
    @Test
    public void test07() {//LinkedHashSet

    }
}
