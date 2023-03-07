package DesignPattern.GuardedObject.MailBoxProject;

public class MailBoxStarter {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new People().start();
        }

        Thread.sleep(1000);

        for (int id : MailBoxes.getIds()) {
            new Postman(id, "content" + id).start();
        }

    }

}
