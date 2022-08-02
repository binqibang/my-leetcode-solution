package qeque;

public class TestQueue {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.Rear();
        circularQueue.isFull();
        circularQueue.deQueue();
        circularQueue.enQueue(4);
        circularQueue.Rear();

    }
}
