package junior.inflearn;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최대힙을 구현하시오.
 * 0이면 최댓값 Output 및 출, -1이면 종료, 그 외에 Queue에 Input
 *
 * * PriorityQueue와 Comparator를 구현하여 해결한다.
 */

public class Problem65 {

    public static void main(String[] args) throws IOException {
        MaxHeap maxHeap = new MaxHeap();
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int data = sc.nextInt();
            if(data == 0) bw.write(maxHeap.printMaxData() + "\n");
            else if(data == -1) break;
            else maxHeap.add(data);
        }

        bw.flush();
    }
}

class MaxHeap {

    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
        if(o1 > o2) return -1;
        else if(o1 < o2) return 1;
        else return 0;
    });

    void add(int data) {
        queue.add(data);
    }

    int printMaxData() {
        return queue.poll();
    }
}
