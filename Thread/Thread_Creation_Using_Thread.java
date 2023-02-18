package Thread;

public class Thread_Creation_Using_Thread {
    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("running");
            }
        };

        thread1.setName("Thread_1");

        thread1.start();

        System.out.println("running in main");

    }

}
