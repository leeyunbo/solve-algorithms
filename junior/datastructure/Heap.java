package datastructure;


import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        myHeap.insert(5);
        System.out.println(Arrays.toString(myHeap.heap));

        myHeap.insert(10);
        System.out.println(Arrays.toString(myHeap.heap));

        myHeap.insert(30);
        System.out.println(Arrays.toString(myHeap.heap));

        myHeap.insert(15);
        System.out.println(Arrays.toString(myHeap.heap));

        myHeap.insert(25);
        System.out.println(Arrays.toString(myHeap.heap));

        myHeap.sort();

    }
}

class MyHeap {

    int[] heap = new int[11];
    int heapSize = 0;

    public void insert(int n) {
        heap[++heapSize] = n;
        int parent = heapSize/2;
        int child = heapSize;
        while(child >= 2 && heap[parent] < heap[child]) {
            SWAP(parent, child);
            child = parent;
            parent = child/2;
        }
    }

    public int delete() {
        int data = heap[1];
        heap[1] = heap[heapSize--];
        int parent = 1;
        int child = 2;
        while(child <= heapSize && heap[parent] < heap[child]) {
            SWAP(parent, child);
            parent = child;
            child = heap[heap[parent * 2] < heap[parent * 2 + 1] ? parent * 2 + 1 : parent * 2];
        }
        return data;
    }

    public void sort() {
        int temp = heapSize;
        for(int i=0; i<temp; i++) {
            System.out.print(delete() + " ");
        }
    }

    public void SWAP(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
}
