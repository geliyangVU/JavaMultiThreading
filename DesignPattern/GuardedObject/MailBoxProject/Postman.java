package DesignPattern.GuardedObject.MailBoxProject;

public class Postman extends Thread {

    private int mailid;
    private String mailBody;

    public Postman(int mailid, String mail) {
        this.mailid = mailid;
        this.mailBody = mail;
    }

    @Override
    public void run() {
        GuardedObjectForMail guardedObjectForMail = MainBoxes.getGuardedObjectForMailById(mailid);
        System.out.println("send mail with mailslot number:");
        System.out.println(guardedObjectForMail.getId());

        guardedObjectForMail.generateObject(mailBody);

    }

}
