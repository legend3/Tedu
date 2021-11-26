package com.legend.status;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep2 {
    //倒计时10秒
    public void TenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if(num == 0) {
                break;
            }
        }
    }

    //打印当前系统时间
    public void printCurrentTime() throws InterruptedException {
        Date currentTime = new Date(System.currentTimeMillis());//获取当前系统时间
        while(true) {
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(currentTime));
            currentTime = new Date(System.currentTimeMillis());//更新当前时间
        }

    }

    public static void main(String[] args) throws InterruptedException {
        TestSleep2 testSleep2 = new TestSleep2();
//        testSleep2.TenDown();
        testSleep2.printCurrentTime();
    }
}
