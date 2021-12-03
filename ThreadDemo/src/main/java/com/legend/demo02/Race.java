package com.legend.demo02;

public class Race implements Runnable{
    private String winner;

    @Override
    public void run() {
        //1.首先来个赛道距离，然后要离终点越来越近
        for (int i = 0; i <= 1000; i++) {//1.1赛程中...
            //5.故事中是乌龟赢的，兔子需要睡觉，所以我们来模拟兔子睡觉
            if(Thread.currentThread().getName().equals("兔子") && i%10==0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(gameOver(i) == true) {
                break;
            }
            //6.终于，乌龟赢得比
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步了");
        }
    }
    //2.判断比赛是否结束
     private boolean gameOver(int step) {
        if(winner != null) {//已有冠军了
            return true;
        }else {
                 if (step >= 1000) {//产生冠军
                     winner = Thread.currentThread().getName();
                     //3.打印出胜利者
                     System.out.println("冠军是" + winner);
                     return true;
             }
         }
        return false;//比赛还在继续
     }

    public static void main(String[] args) {
        Race race = new Race();

        //4.龟兔赛跑开始
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}
