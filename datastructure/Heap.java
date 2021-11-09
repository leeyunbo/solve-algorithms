package datastructure;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        myHeap.insert(5);
        myHeap.insert(10);
        myHeap.insert(30);
        myHeap.insert(15);
        myHeap.insert(25);
        myHeap.delete();
        System.out.println(Arrays.toString(myHeap.heap));
    }
}

class MyHeap {

    int[] heap = new int[11];
    int idx = 1;

    public void insert(int n) {
        heap[idx] = n;
        int parent = idx/2;
        int child = idx;
        while(child >= 2 && heap[parent] < heap[child]) {
            SWAP(parent, child);
            child = parent;
            parent = child/2;
        }
        idx++;
    }

    public int delete() {
        int data = heap[1];
        heap[1] = heap[idx--];
        int parent = 1;
        int child = 2;
        while(child <= idx && heap[parent] < heap[child]) {
            SWAP(parent, child);
            parent = child;
            child = heap[heap[parent * 2] < heap[parent * 2 + 1] ? parent * 2 + 1 : parent * 2];
        }
        return data;
    }

    public void SWAP(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
}
