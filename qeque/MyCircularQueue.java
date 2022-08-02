package qeque;

/**
 * LeetCode #622 (Medium)
 * @author binqibang
 * @date 2022/8/2
 */
public class MyCircularQueue {

    private final int[] array;
    private int front;
    private int rear;

    public MyCircularQueue(int k) {
        array = new int[k + 1];
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % array.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % array.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int idx = rear > 0 ? rear - 1 : rear + array.length - 1;
        return array[idx];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % array.length == front;
    }
}
