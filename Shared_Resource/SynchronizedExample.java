package Shared_Resource;

public class SynchronizedExample {
    static int counter = 0;

    static Object lockObject = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            // System.out.println("Thread1 start");
            for (int i = 0; i < 5000; i++) {
                synchronized (lockObject) {
                    counter++;
                }
            }

        }, "thread1");

        Thread thread2 = new Thread(() -> {
            // System.out.println("Thread2 start");
            for (int i = 0; i < 5000; i++) {
                synchronized (lockObject) {
                    counter--;
                }
            }

        }, "thread2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("counter value:" + counter);

        System.out.println("Main thread finished");

    }

}
