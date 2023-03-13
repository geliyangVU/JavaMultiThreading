package ReentrantLock;

public class ReentrantLock2 {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("try to Acquire lock");
            if (!reentrantLock.tryLock()) {
                return;
            }

            try {
                System.out.println("Acquired lock");

            } finally {
                reentrantLock.unlock();
            }
        });
    }

}
