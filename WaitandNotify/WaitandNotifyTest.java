package WaitandNotify;

public class WaitandNotifyTest {

    final static Object lockObject = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lockObject) {
                System.out.println("thread1 running");

                try {
                    lockObject.wait(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println("thread1 continues running");

            }
        }, "thread1").start();

        new Thread(() -> {
            synchronized (lockObject) {
                System.out.println("thread2 running");

                try {
                    lockObject.wait(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println("thread2 continues running");
            }
        }, "thread2").start();

        Thread.sleep(1500);
        synchronized (lockObject) {
            lockObject.notify();
        }

    }

}
