/**
https://programmers.co.kr/learn/courses/30/lessons/42628
*/
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
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


        return priorityQueue.isEmpty() ? new int[]{0,0} : new int[]{reversePriorityQueue.peek(), priorityQueue.peek()};
    }
}
