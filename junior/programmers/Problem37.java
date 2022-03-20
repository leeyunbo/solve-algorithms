package junior.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem37 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bufferedReader.readLine());

        String[] operations = new String[cnt];

        for(int i=0; i<cnt; i++) {
            operations[i] =  bufferedReader.readLine();
        }

        Problem37 problem37 = new Problem37();
        System.out.println(Arrays.toString(problem37.solution(operations)));
    }

    public int[] solution(String[] operations) {
        int[] answer;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reversePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String[] commandLine = operation.split(" ");
            int data = Integer.parseInt(commandLine[1]);
            switch (commandLine[0]) {
                case "I" -> {
                    priorityQueue.offer(data);
                    reversePriorityQueue.offer(data);
                }
                case "D" -> {
                    if (priorityQueue.isEmpty()) continue;
                    if (data == 1) {
                        int removeData = reversePriorityQueue.poll();
                        priorityQueue.remove(removeData);
                    } else {
                        int removeData = priorityQueue.poll();
                        reversePriorityQueue.remove(removeData);
                    }
                }
            }
        }

        if(priorityQueue.isEmpty()) {
            answer = new int[]{0,0};
        }
        else {
            answer = new int[]{reversePriorityQueue.peek(), priorityQueue.peek()};
        }

        return answer;
    }
}
