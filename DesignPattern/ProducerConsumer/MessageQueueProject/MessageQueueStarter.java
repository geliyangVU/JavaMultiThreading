package DesignPattern.ProducerConsumer.MessageQueueProject;

public class MessageQueueStarter {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue mq = new MessageQueue(2);

        for (int i = 0; i < 5; i++) {
            int id = i;
            new Thread(() -> {
                mq.put(new Message(id, "message" + id));
            }, "producer" + i).start();
        }

        Thread.sleep(1000);

        new Thread(() -> {
            while (true) {
                Message message = mq.take();
                System.out.println(message);
            }
        }, "consumer").start();
    }

}
