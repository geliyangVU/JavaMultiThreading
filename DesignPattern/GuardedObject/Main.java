package DesignPattern.GuardedObject;

public class Main {
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();

        new Thread(() -> {
            System.out.println("thread 1");
            Object response = guardedObject.getObject(2000);
            System.out.println(response + "from thread 1");

        }, "thread1").start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            guardedObject.generateObject("response is generated");
        }, "workerThread").start();

    }

}
