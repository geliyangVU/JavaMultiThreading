package Thread;

public class Thread_Creation_Using_lamdaExpression {
    public static void main(String[] args) {
        // Lamda expression
        Thread thread = new Thread(() -> {
            System.out.println("Thread2");
        }, "thread2");
        thread.start();
    }
}
