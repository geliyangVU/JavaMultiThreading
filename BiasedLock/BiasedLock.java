package BiasedLock;

public class BiasedLock {
    public static void main(String[] args) {
        Dog d = new Dog();
        // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // System.out.println(ClassLayout.parseInstance(d).toPrintable(true));

    }

}

// JVM command:
// -XX:BiasedLockingStartupDelay=0 meaning: make biased lock take effect
// immediately after object is created

// -XX:-UseBiasedLocking meaning: stop using biased lock
// -XX:+UseBiasedLocking meaning: use biased lock