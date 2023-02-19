package Thread;

public class Thread_Multi_Join {
    public static int r1 = 0;
    public static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        thread_join_test();

    }

    private static void thread_join_test() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 start");
            try {
                Thread.sleep(1000);
                System.out.println("Thread1 stopped");
                r1 = 10;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }, "thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 start");
            try {
                Thread.sleep(1000);
                System.out.println("Thread2 stopped");
                r2 = 15;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }, "thread2");

        thread1.start();
        thread2.start();

        thread1.join();// join waits for thread 1 to finish and.
        thread2.join();

        System.out.println("Main thread stopped");
        System.out.println("r1:" + r1 + "r2:" + r2);

    }

}
