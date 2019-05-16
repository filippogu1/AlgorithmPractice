package AlgorithmPractice;

import java.util.HashMap;
import java.util.Map;

public class QueueWithHashMap {

    private Map<Integer, Integer> map;
    private int capacity;
    private int size;
    private int head;
    private int tail;

    public QueueWithHashMap(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = -1;
        tail = -1;
    }

    public void add(int val) {
        if (size >= capacity) {
            System.out.println("Queue is full now! Cannot add values");
            return;
        }
        if (size == 0) {
            head = 0;
            tail = 1;
            map.put(head, val);
        } else {
            map.put(tail, val);
            tail = (tail + 1) % capacity;
        }
        size++;
    }

    public Integer peek() {
        if (isEmpty()) return null;
        return map.get(head);
    }

    public Integer poll() {
        if (isEmpty()) return null;
        int num = map.get(head);
        map.remove(head);
        size--;
        head = (head + 1) % capacity;
        return num;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        QueueWithHashMap q = new QueueWithHashMap(5);
        System.out.println("Queue is empty? - " + q.isEmpty());
        q.add(1);
        System.out.println("head is at " + q.head + ". Tail is at " + q.tail);
        q.add(2);
        System.out.println("head is at " + q.head + ". Tail is at " + q.tail);
        q.add(3);
        System.out.println("head is at " + q.head + ". Tail is at " + q.tail);
        q.peek();
        // q.poll();
        System.out.println("head is at " + q.head + ". Tail is at " + q.tail);
        System.out.println("queue size is: " + q.size);
        q.add(4);
        System.out.println("head is at " + q.head + ". Tail is at " + q.tail);
        q.add(5);
        System.out.println("head is at " + q.head + ". Tail is at " + q.tail);
        q.add(6);
        System.out.println("head is at " + q.head + ". Tail is at " + q.tail);

        System.out.println(q.poll());
        System.out.println("head is at " + q.head + ". Tail is at " + q.tail);
    }
}
