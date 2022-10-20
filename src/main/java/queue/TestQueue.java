package queue;

public class TestQueue {
    public static void main(String[] args) {
        // Test MyCircularQueue
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

        // Test MyCircularDeque
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        circularDeque.insertLast(1);    // 返回 true
        circularDeque.insertLast(2);    // 返回 true
        circularDeque.insertFront(3);   // 返回 true
        circularDeque.insertFront(4);   // 已经满了，返回 false
        circularDeque.getRear();    // 返回 2
        circularDeque.isFull();	    // 返回 true
        circularDeque.deleteLast(); // 返回 true
        circularDeque.insertFront(4);   // 返回 true
        circularDeque.getFront();   // 返回 4
    }
}
