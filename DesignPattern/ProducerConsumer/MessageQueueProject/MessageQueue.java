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
                    messageQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = messageQueue.removeFirst();
            messageQueue.notifyAll();
            return message;
        }
    }

    public void put(Message message) {
        synchronized (messageQueue) {

            while (capacity == messageQueue.size()) {
                try {
                    messageQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            messageQueue.addLast(message);
            messageQueue.notifyAll();
        }
    }

}
