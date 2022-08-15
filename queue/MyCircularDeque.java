package queue;

/**
 * LeetCode #641 (Medium)
 * @author binqibang
 * @date 2022/8/15
 */
public class MyCircularDeque {
    private final int[] array;
    private int front;
    private int rear;
    private final int size;

    public MyCircularDeque(int k) {
        array = new int[k + 1];
        front = 0;
        rear = 0;
        size = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front + size - 1) % size;
        array[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear + size - 1) % size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int idx = (rear + size - 1) % size;
        return array[idx];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
