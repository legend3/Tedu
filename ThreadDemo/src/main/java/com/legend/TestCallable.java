package com.legend;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        WebDownLoad webDownLoad = new WebDownLoad();
        webDownLoad.downLoader(url, name);
        System.out.println("下载文件" + name + "完成！");
        return true;
        }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3.创建目标对
        TestCallable t1 = new TestCallable("https://www.kuangstudy.com/assert/img/about1.png", "01.png");
        TestCallable t2 = new TestCallable("https://www.kuangstudy.com/assert/img/about1.png", "02.png");
        TestCallable t3 = new TestCallable("https://www.kuangstudy.com/assert/img/about1.png", "03.png");
        //4. 创建执行服务
        ExecutorService es = Executors.newFixedThreadPool(3);//创建线程池
        //5. 提交执行
        Future<Boolean> result1 = es.submit(t1);
        Future<Boolean> result2 = es.submit(t1);
        Future<Boolean> result3 = es.submit(t1);

        //6.获取线程返回结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        //7.关闭服务
        es.shutdownNow();
    }

}

class WebDownLoad_Callable {
    public void downLoader(String url, String name) {
        try {
               FileUtils.copyURLToFile(new URL(url), new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("下载出错了");
            }
        }
}