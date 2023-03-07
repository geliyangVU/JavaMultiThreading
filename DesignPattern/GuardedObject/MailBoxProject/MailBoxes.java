package DesignPattern.GuardedObject.MailBoxProject;

import java.util.*;

public class MailBoxes {
    // Hashtable is ThreadSafe collection
    private static Map<Integer, GuardedObjectForMail> mailBoxes = new Hashtable<>();

    private static int id = 1;

    private static synchronized int generateId() {
        id++;
        return id;
    };

    public static GuardedObjectForMail createGuardedObjectForMail() {
        GuardedObjectForMail guardedObjectForMail = new GuardedObjectForMail(generateId());
        mailBoxes.put(guardedObjectForMail.getId(), guardedObjectForMail);
        return guardedObjectForMail;
    }

    public static GuardedObjectForMail getGuardedObjectForMailById(int id) {
        return mailBoxes.remove(id);// remove the mailbox, return the guardedObject.
    }

    public static Set<Integer> getIds() {
        return mailBoxes.keySet();
    }

}
