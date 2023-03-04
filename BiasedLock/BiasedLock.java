package BiasedLock;

import java.net.SocketImpl;

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
