package BiasedLock;

public class BiasedLockToLightweightLock {
    public static void main(String[] args) {
        Dog d = new Dog();

        new Thread(() -> {
            // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

            synchronized (d) {
                // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

            }
            // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

            synchronized (BiasedLockToLightweightLock.class) {
                BiasedLockToLightweightLock.class.notify();
            }

        }, "thread1").start();

        new Thread(() -> {
            // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

            synchronized (BiasedLockToLightweightLock.class) {
                // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));
                try {
                    BiasedLockToLightweightLock.class.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

            synchronized (d) {
                // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

            }

            // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

        }, "thread2").start();

    }

}