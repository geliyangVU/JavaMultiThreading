package Thread;

public class Thread_Join {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        thread_join_test();

    }

    private static void thread_join_test() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 start");
            try {
                Thread.sleep(1000);
                System.out.println("Thread1 stopped");
                count = count + 10;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }, "thread1");

        thread1.start();
        thread1.join();// join waits for thread 1 to finish and count value is updated.
        System.out.println("Main thread stopped");
        System.out.println("count:" + count);

    }

}
