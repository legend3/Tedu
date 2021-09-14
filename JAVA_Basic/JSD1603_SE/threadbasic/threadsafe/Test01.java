package threadbasic.threadsafe;

public class Test01 {
    public static void main(String[] args) {
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//            }
//        };
        MyInt myint = new MyInt();
        for(int i = 0;i<= 2;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        System.out.println(Thread.currentThread() + " -> " + myint.getNum());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
    static class MyInt{
        int num = 0;
        public int getNum() {
            return num++;
        }
    }
}
