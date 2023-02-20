package DaemonThread;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 start");
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            System.out.println("Thread1 ends");

        }, "thread1");

        thread1.setDaemon(true);
        Thread.sleep(1000);
        System.out.println("Main thread ends");

    }

}
