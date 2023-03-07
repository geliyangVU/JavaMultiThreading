package DesignPattern.GuardedObject.MailBoxProject;

public class People extends Thread {
    @Override
    public void run() {

        GuardedObjectForMail guardedObjectForMail = MailBoxes.createGuardedObjectForMail();
        System.out.println("People wants to get mail id:");
        System.out.println(guardedObjectForMail.getId());

        Object mailResponse = guardedObjectForMail.getObject(5000);
        System.out.println("Received mail id:");
        System.out.println(guardedObjectForMail.getId());
        System.out.println(mailResponse);
        System.out.println("Done");

    }

}
