package Thread;

public class Thread_Interruption {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("thread1");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    System.out.println("thread 1 interrupted.");

                    e.printStackTrace();
                }
            }
        };

        t1.start();

        try {
            // main thread
            System.out.println("main thread:");
            Thread.sleep(1000);
            // Interrupting

            t1.interrupt();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println(t1.getState());
    }
}
