package backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NNumber {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = scanner.nextInt();
        for(int i=0; i<testCase; i++) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            for(int j=0; j<10; j++) {
                priorityQueue.offer(scanner.nextInt());
            }
            for(int k=0; k<2; k++) {
                priorityQueue.poll();
            }
            bw.write(priorityQueue.poll() + "\n");
        }
        bw.flush();
    }
}
