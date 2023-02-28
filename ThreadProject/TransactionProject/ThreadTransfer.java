package ThreadProject.TransactionProject;

import ThreadProject.TransactionProject.Account;

public class ThreadTransfer {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);
        Thread thread1 = new Thread(()->{
            for(int i = 0; i< 1000; i++){
                a.transfer(b,1);
            }
        },"thread1");

         Thread thread2 = new Thread(()->{
            for(int i = 0; i< 1000; i++){
                b.transfer(a,1);
            }
        },"thread2");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(a.getMoney()+b.getMoney());
    }

}
