package day05.weakHashMap;


import org.junit.Test;

import java.util.WeakHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCases {
    WeakHashMap<Object, Object> weakHashMap = new WeakHashMap<>();
    String s = "first";
    Integer i = 1;
    final Lock lock = new ReentrantLock();
    final Condition condition  = lock.newCondition();

    @Test
     public void test01() throws InterruptedException {
        weakHashMap.put(s, i);

        s = null;
        System.gc();//申明：gc不能被开发者调用，gc回收是不能被确定的！

//        condition.await().atMost(10, TimeUnit.SECONDS).util(weakHashMap::isEmpty);//没弄清？大概是延时不让main线程等待执行线程触发gc完
        System.out.println(weakHashMap.size());
    }
    @Test
    public void test02() {
        /*执行的时候i会被封装为Integer类型的，Integer保留了-128到127的缓存。
        但是对于int来说范围大很多，因此那些Key <= 127的Entry将不会进行自动回收，但是那些大于127的将会被回收，
        因此最后的尺寸总是会稳定在128左右。*/
        for(int i=0; i<1000;i++) {
            weakHashMap.put(i, "字符串");
            System.gc();
            System.out.println("Map Size:" + weakHashMap.size());
        }
    }
}
