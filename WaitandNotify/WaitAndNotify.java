package WaitandNotify;

public class WaitAndNotify {

    final static Object lockObject = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lockObject) {
                System.out.println("thread1 running");

                try {
                    lockObject.wait();
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
                    lockObject.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println("thread2 continues running");
            }
        }, "thread2").start();

        Thread.sleep(2000);
        synchronized (lockObject) {
            lockObject.notify();
        }

    }

}
