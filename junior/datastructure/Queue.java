package datastructure;

/**
 * 배열을 이용한 원형 큐 구현
 * 원형 큐는 empty 상태와 full 상태를 구분하기 위해 항상 한자리를 비워두도록 한다.
 */

import java.util.Scanner;

public class Queue {

    public static void main(String[] args) {
        QueueSimulator queueSimulator = new QueueSimulator(10);
        Scanner scanner = new Scanner(System.in);

        while(true) {

            String data = scanner.nextLine();
            if(data.equals("-1")) return;
            else if(data.equals("insert")) {
                queueSimulator.enqueue(scanner.nextInt());
            }
            else if(data.equals("delete")) {
                queueSimulator.dequeue();
            }

            System.out.println(queueSimulator.toString());
        }
    }
}

class QueueSimulator {

    private int rear = 0;
    private int front = 0;
    private int QUEUE_MAX_SIZE;
    private Integer[] queue;

    public QueueSimulator(int QUEUE_MAX_SIZE) {
        this.QUEUE_MAX_SIZE = QUEUE_MAX_SIZE;
        queue = new Integer[QUEUE_MAX_SIZE];
    }

    void enqueue(Integer data) {
        if(isFull()) {
            return;
        }

        rear = (++rear) % QUEUE_MAX_SIZE;
        queue[rear] = data;
    }

    void dequeue() {
        if(isEmpty()) {
            return;
        }

        front = (++front) % QUEUE_MAX_SIZE;
        queue[front] = null;
    }

    boolean isEmpty() {
        if(rear == front) {
            return true;
        }
        return false;
    }

    boolean isFull() {
        if((rear+1) % QUEUE_MAX_SIZE == front) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<QUEUE_MAX_SIZE; i++) {
            result += (queue[i] + " ");
        }
        return result;
    }

}
