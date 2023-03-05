package DesignPattern.GuardedObject;

public class Main {
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();

        new Thread(() -> {
            System.out.println("thread 1 wait for response");
            Object response = guardedObject.getObject();
            System.out.println(response + "from thread 1");

        }, "thread1").start();

        new Thread(() -> {
            System.out.println("worker thread generate response");
            guardedObject.generateObject("response is generated");
        }, "workerThread").start();

    }

}
