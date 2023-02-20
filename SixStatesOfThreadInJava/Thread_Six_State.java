package SixStatesOfThreadInJava;

public class Thread_Six_State {
    public static void main(String[] args) {

        // Thread 1, NEW state
        Thread thread1 = new Thread("Thread1") {
            @Override
            public void run() {
                System.out.println("Running in Thread 1");

            }
        };

        // Thread2, RUNNING state
        Thread thread2 = new Thread("Thread2") {
            @Override
            public void run() {
                while (true) {// runnable

                }
            }
        };

        thread2.start();

        // Thread 3
        Thread thread3 = new Thread("Thread3") {
            @Override
            public void run() {
                System.out.println("Running in Thread 3");
            }
        };

        thread3.start();

        // Thread 4
        Thread thread4 = new Thread("Thread4") {
            @Override
            public void run() {
                synchronized (Thread_Six_State.class) {
                    try {
                        Thread.sleep(100000000);// timed_waiting
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread4.start();

        // Thread 5
        Thread thread5 = new Thread("Thread5") {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread5.start();

        // Thread 6
        Thread thread6 = new Thread("Thread6") {
            @Override
            public void run() {
                synchronized (Thread_Six_State.class) {
                    try {
                        Thread.sleep(100000000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread6.start();

        System.out.println("thread1 state:" + thread1.getState());
        System.out.println("thread2 state:" + thread2.getState());
        System.out.println("thread3 state:" + thread3.getState());
        System.out.println("thread4 state:" + thread4.getState());
        System.out.println("thread5 state:" + thread5.getState());
        System.out.println("thread6 state:" + thread6.getState());

    }

}
