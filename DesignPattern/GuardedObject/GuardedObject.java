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

    public Object getObject(long timeout) {

        synchronized (this) {
            long beginTime = System.currentTimeMillis();
            long passedTime = 0;
            while (response == null) {

                long waitTime = timeout - passedTime;// calculate wait time

                if (waitTime <= 0) {
                    System.out.println("time out occured");
                    break;
                }

                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                passedTime = System.currentTimeMillis() - beginTime;
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
