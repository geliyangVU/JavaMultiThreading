package DesignPattern.GuardedObject.MailBoxProject;

import java.util.*;

public class MainBoxes {
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

    public static Set<Integer> getIds() {
        return mailBoxes.keySet();
    }

}
