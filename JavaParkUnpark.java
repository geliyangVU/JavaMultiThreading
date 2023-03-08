import java.util.concurrent.locks.LockSupport;

public class JavaParkUnpark {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println("Start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("park");

            LockSupport.park();
            System.out.println("resume");
        }, "thread1");
        thread1.start();

        Thread.sleep(2000);
        System.out.println("unpark");
        LockSupport.unpark(thread1);

    }

}
