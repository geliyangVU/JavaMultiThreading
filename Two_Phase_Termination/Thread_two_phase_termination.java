package Two_Phase_Termination;

public class Thread_two_phase_termination {
    public static void main(String[] args) throws InterruptedException {
        TwoPhasetermination twoPhasetermination = new TwoPhasetermination();
        twoPhasetermination.start();

        Thread.sleep(4000);
        twoPhasetermination.stop();

    }

}

class TwoPhasetermination {
    private Thread monitorThread;

    // start monitor thread
    public void start() {
        monitorThread = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()) {
                    // clean uo resources and locks
                    System.out.println("cleaning up");
                    break;
                }

                try {
                    Thread.sleep(1000);// exception will be thrown at line 33, need to set the isInterrupted flag
                    System.out.println("monitoring");// will be caught at line 23

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    currentThread.interrupt();// set the isInterrupted flag. continue
                }

            }

        });

        monitorThread.start();
    }

    // stop the monitor thread
    public void stop() {
        monitorThread.interrupt();
    }
}