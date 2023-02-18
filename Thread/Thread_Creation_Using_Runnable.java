package Thread;

public class Thread_Creation_Using_Runnable {
    public static void main(String[] args) {
        // more versatile, recommended way of creating thread.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnable's run method");
            }
        };

        Thread thread = new Thread(runnable, "threadwithrunnable");
        System.out.println("running in main");

        thread.start();
    }

}
