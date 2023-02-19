package Thread;

public class Thread_TimedWaiting {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        // System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println(t1.getState());
    }
}
