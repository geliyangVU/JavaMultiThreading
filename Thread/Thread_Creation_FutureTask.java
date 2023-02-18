package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Thread_Creation_FutureTask {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.print("running");
                Thread.sleep(5000);
                return 200;
            }
        });

        Thread callerThread = new Thread(task, "t1");

        callerThread.start();

        System.out.println("Result from FutureTask:" + task.get());
        // System.out.println(task.get());

    }

}
