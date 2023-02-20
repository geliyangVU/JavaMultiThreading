package Shared_Resource;

public class SynchronizedObjectOrientedExample {
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();

        Thread thread1 = new Thread(() -> {
            // System.out.println("Thread1 start");
            for (int i = 0; i < 5000; i++) {
                room.incrementCounter();
            }

        }, "thread1");

        Thread thread2 = new Thread(() -> {
            // System.out.println("Thread2 start");
            for (int i = 0; i < 5000; i++) {
                room.decrementCounter();
            }

        }, "thread2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("counter value:" + room.getCounter());

        System.out.println("Main thread finished");

    }

}

class Room {
    private int counter = 0;

    public void incrementCounter() {
        synchronized (this) {
            counter++;
        }
    }

    public void decrementCounter() {
        synchronized (this) {
            counter--;
        }
    }

    public int getCounter() {
        synchronized (this) {
            return counter;
        }
    }
}
