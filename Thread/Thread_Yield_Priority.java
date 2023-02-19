package Thread;

public class Thread_Yield_Priority {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for (;;) {
                System.out.println("----->1  :  " + count);
                count++;
            }
        };

        Runnable task2 = () -> {
            int count = 0;
            for (;;) {
                // Thread.yield();
                System.out.println("----->2  :  " + count);
                count++;
            }
        };

        Thread thread1 = new Thread(task1, "thread1");
        Thread thread2 = new Thread(task2, "thread2");

        // thread1.setPriority(Thread.MAX_PRIORITY);
        // thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
    }

}
