package Shared_Resource;

public class SynchronizedMethodAndStaticDifference {
    // synchronized method lock the current object ---> synchronized(this)
    // synchronized static method will lock the current class-->
    // Synchronized(XXX.class)
}

class Room2 {
    private int counter = 0;

    public synchronized void incrementCounter() {
        counter++;
    }

    public synchronized void decrementCounter() {
        counter--;
    }

    public synchronized int getCounter() {
        return counter;
    }
}
