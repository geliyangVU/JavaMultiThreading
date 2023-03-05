package DesignPattern.GuardedObject;

public class GuardedObject {
    private Object response;

    public Object getObject() {
        synchronized (this) {

            // if response does not exist
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            return response;
        }
    }

    public void generateObject(Object responseToBeGenerated) {
        synchronized (this) {
            this.response = responseToBeGenerated;
            this.notifyAll();
        }

    }

}
