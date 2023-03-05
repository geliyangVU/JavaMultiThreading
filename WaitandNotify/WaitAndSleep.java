package WaitandNotify;

public class WaitAndSleep {
    final static Object lockObject = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lockObject) {
                System.out.println("thread1 running");

                try {
                    Thread.sleep(10000);
                    // lockObject.wait(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println("thread1 continues running");

            }
        }, "thread1").start();

        Thread.sleep(1000);
        synchronized (lockObject) {
            System.out.println("acquired lock");

        }

    }

}
