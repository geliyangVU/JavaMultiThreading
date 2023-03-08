package Shared_Resource.DeadLock;

import java.util.concurrent.ThreadPoolExecutor;

public class DeadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        Thread thread1 = new Thread(() -> {

            synchronized (a) {
                System.out.println("thread 1 acquire lock A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (b) {
                    System.out.println("thread 1 acquire lock b");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        }, "thread1");

        Thread thread2 = new Thread(() -> {

            synchronized (b) {
                System.out.println("thread 2 acquire lock b");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (a) {
                    System.out.println("thread 2 acquire lock a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        }, "thread2");

        thread1.start();
        thread2.start();

    }

}

// Command to locate deadlock

// jps -to look at all java process ID

// geliyang@Gelis-MacBook-Air JavaMultiThreading % jps
// 6023 DeadLock
// 6040 Jps
// 569 Bootstrap
// 1900 org.eclipse.equinox.launcher_1.6.400.v20210924-0641. jar
// 573 war

// jstack <processID>
// example : jstack 6023

// Found one Java-level deadlock:============================="thread1":
// waiting to
// lock monitor 0x00006000006e88f0(object 0x0000000787f1c100,
// a java.lang.Object),
// which is
// held by"thread2"

// "thread2":
// waiting to
// lock monitor 0x00006000006ec4e0(object 0x0000000787f1c0f0,
// a java.lang.Object),
// which is
// held by"thread1"

// Java stack information for
// the threads
// listed above:
//