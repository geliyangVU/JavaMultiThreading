package DesignPattern.ProducerConsumer.MessageQueueProject;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageQueue {

    private Deque<Message> messageQueue = new ArrayDeque<>();

    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public Message take() {
        synchronized (messageQueue) {

            while (messageQueue.isEmpty()) {
                try {
                    System.out.println("MQ is empty, waiting.");
                    messageQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("MQ is not empty, consume a message");

            Message message = messageQueue.removeFirst();
            messageQueue.notifyAll();
            return message;
        }
    }

    public void put(Message message) {
        synchronized (messageQueue) {

            while (capacity == messageQueue.size()) {
                try {
                    System.out.println("MQ is full, waiting.");

                    messageQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("MQ is not full, produce a message");

            messageQueue.addLast(message);
            messageQueue.notifyAll();
        }
    }

}
