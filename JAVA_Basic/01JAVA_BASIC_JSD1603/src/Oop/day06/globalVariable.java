package Oop.day06;

/**
 * CLassName: globalVariable
 * Description: Java的全局变量
 *              注：java中的全局变量是由public修饰的static成员变量，形如public static int ID;
 *                      java中的全局变量是放在静态方法区中的，所有的实例对象会共享同一份全局变量。所以一旦对某个类实例化后对其中
 *                          的全局变量做出修改，那么其他的实例其中的全局变量值也相应的会被修改。
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/7/9 14:37
 *
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/7/9 14:37      LEGEND        1.0         1.0 Version
 */

public class globalVariable {
    public static int id;//全局变量
    public static int name;//全局变量

    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        globalVariable.id = id;
    }
    public static int getName() {
        return name;
    }
    public static void setName(int name) {
        globalVariable.name = name;
    }

    public static void main(String[] args) {
        globalVariable test1 = new globalVariable();
        globalVariable test2 = new globalVariable();

        test1.setId(1);//实例引用也可以调静态方法
        System.out.println(test1.getId());
        System.out.println(test2.getId());//test2实例的也变了
        test1.setId(2);//实例引用也可以调静态方法
        System.out.println(test1.getId());
        System.out.println(test2.getId());//test2实例的也变了
    }
}
