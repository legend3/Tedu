package threadbasic.threadmethod.p3sleep;
/**
 * 使用线程休眠 Thread.sleep 完成一个简易的计时器
 * Author : 蛙课网老崔
 */
public class SimpleTimer {
    public static void main(String[] args) {
        int remaining = 10; //60秒开始计时
        //读取 main 方法的参数
        if(args.length == 1) {
            remaining = Integer.parseInt(args[0]);//字符串转整数，修改remaining变量
        }
        while(true) {
            System.out.println("Remaining:" + remaining);
            remaining--;
            if(remaining == 0) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done....");
    }
}
