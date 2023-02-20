package ThreadProject;

public class ThreadProjectSimple {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 clean pot");
            try {
                Thread.sleep(1000);
                System.out.println("Thread1 boil water");
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 clean tea pot");
            try {
                Thread.sleep(1000);
                System.out.println("Thread2 clean tea cups");
                Thread.sleep(2000);
                System.out.println("Thread2 get tea");
                Thread.sleep(1000);
                try {
                    thread1.join();
                } catch (Exception e) {
                    // TODO: handle exception
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread2 make tea");

        }, "thread2");

        thread1.start();
        thread2.start();

    }

}
