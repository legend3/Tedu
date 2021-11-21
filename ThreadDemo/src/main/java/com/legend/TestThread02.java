package com.legend;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread02 extends Thread{
    private String url;
    private String name;

    public TestThread02(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoad wd = new WebDownLoad();
        wd.downLoader(url, name);
        System.out.println(Thread.currentThread().getName() + "下载完毕！");
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://www.kuangstudy.com/assert/img/about1.png", "01.png");
        TestThread02 t2 = new TestThread02("https://www.kuangstudy.com/assert/img/about1.png", "02.png");
        TestThread02 t3 = new TestThread02("https://www.kuangstudy.com/assert/img/about1.png", "03.png");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownLoad {
    public void downLoader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常，downloader方法出错");
        }
    }
}