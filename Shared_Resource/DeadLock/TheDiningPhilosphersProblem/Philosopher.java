package Shared_Resource.DeadLock.TheDiningPhilosphersProblem;

public class Philosopher extends Thread {
    String PhilospherName;
    Chopstick left;
    Chopstick right;

    // constructor
    public Philosopher(String name, Chopstick left, Chopstick right) {
        PhilospherName = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (left) {
                synchronized (right) {
                    eat();
                }
            }
        }

    }

    private void eat() {
        System.out.print(PhilospherName);
        System.out.println(" eating");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
