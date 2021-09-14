package threadbasic.threadmethod.p8daemon;

public class SubDemoThread extends Thread{
    @Override
    public void run() {
        super.run();
        while(true){
            System.out.println("sub thread.....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
