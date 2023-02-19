package Thread;

public class Thread_State {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("running");
            }
        };

        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());

    }

}
