package backjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        /**
         * 1. 균형을 맞춰야 한다.
         * 2. MaxHeap Top이 Median이므로, MaxHeap의 Top이 MinHeap Top보다 항상 작아야한다.   -> 조건 : 중간 숫자가 2개인 경우 작은 숫자가 무조건 Median이다.
         */
        int cnt = Integer.parseInt(bufferedReader.readLine());
        for(int i=0; i<cnt; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if(i==0) {
                maxHeap.offer(num);
            }
            else {
                if(maxHeap.size() > minHeap.size()) {
                    minHeap.offer(num);
                }
                else {
                    maxHeap.offer(num);
                }

                if(maxHeap.peek() > minHeap.peek()) {
                    int maxTop = maxHeap.poll();
                    int minTop = minHeap.poll();
                    maxHeap.offer(minTop);
                    minHeap.offer(maxTop);
                }
            }

            bufferedWriter.write(maxHeap.peek()+"\n");
        }
        bufferedWriter.flush();
    }
}
