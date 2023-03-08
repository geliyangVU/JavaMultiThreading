package Shared_Resource.MultipleLock;

public class BigRoom {

    private final Object studyRoom = new Object();

    private final Object bedRoom = new Object();

    public void sleep() {
        synchronized (bedRoom) {
            try {
                System.out.println("Sleeping");
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void study() {
        synchronized (studyRoom) {
            try {
                System.out.println("Studying");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
