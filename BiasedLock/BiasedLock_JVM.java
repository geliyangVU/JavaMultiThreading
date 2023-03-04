package BiasedLock;

public class BiasedLock_JVM {
    // Use : -XX:-UseBiasedLocking meaning: stop using biased lock

    public static void main(String[] args) {
        Dog d = new Dog();
        // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

        synchronized (d) {
            // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

        }
        // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

    }

}
