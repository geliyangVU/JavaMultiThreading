package WaitandNotify;

public class WaitAndNotifyCorrectUseExample {
    final static Object room = new Object();
    static boolean hasCigarette;
    static boolean hasFood;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (room) {
                System.out.println("thread1 running");

                while (!hasCigarette) {
                    System.out.println("thread1 no cigarette");

                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (hasCigarette) {
                    System.out.println("thread1 done work");
                } else {
                    System.out.println("thread1 has not done work");
                }

            }
        }, "thread1").start();

        new Thread(() -> {
            synchronized (room) {
                System.out.println("thread2 running");

                if (!hasFood) {
                    System.out.println("thread2 no food");

                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (hasFood) {
                    System.out.println("thread2 has done work");
                } else {
                    System.out.println("thread2 has not done work");
                }
            }

        }, "thread2").start();

        Thread.sleep(500);
        new Thread(() -> {
            synchronized (room) {
                System.out.println("food delivered");
                hasFood = true;
                room.notifyAll();
            }
        }, "delivery").start();

        Thread.sleep(2500);

        new Thread(() -> {
            synchronized (room) {
                System.out.println("cigarette delivered");
                hasCigarette = true;
                room.notifyAll();
            }
        }, "cigarette delivery").start();

    }

}
