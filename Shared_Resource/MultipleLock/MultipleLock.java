package Shared_Resource.MultipleLock;

public class MultipleLock {
    public static void main(String[] args) {
        BigRoom bigRoom = new BigRoom();

        Thread thread1 = new Thread(() -> {
            bigRoom.sleep();
        }, "thread1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            bigRoom.study();
        }, "thread2");
        thread2.start();

    }
}