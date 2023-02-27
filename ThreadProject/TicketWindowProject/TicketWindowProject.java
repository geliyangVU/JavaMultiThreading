package ThreadProject.TicketWindowProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TicketWindowProject {
    public static void main(String[] args) throws InterruptedException {
        TicketWindow ticketWindow = new TicketWindow(1000);

        List<Thread> threadList = new ArrayList<>();

        List<Integer> amountList = new Vector<>();

        for (int i = 0; i < 5000; i++) {
            Thread thread = new Thread(() -> {
                int amount = ticketWindow.sell(2);
                amountList.add(amount);
            });

            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("Tickets remaining:" + ticketWindow.getCount());
        System.out.println("Tickets sold:" + amountList.stream().mapToInt(i -> i).sum());

    }

}

class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public synchronized int sell(int ticketAmount) {
        if (this.count >= ticketAmount) {
            this.count -= ticketAmount;
            return ticketAmount;
        } else {
            return 0;
        }
    }
}