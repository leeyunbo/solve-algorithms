package junior.programmers.study;

import java.util.PriorityQueue;

public class Problem14 {

    public static void main(String[] args) {

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        while(priorityQueue.peek() < K && priorityQueue.size() != 1) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            priorityQueue.add(first + (second * 2));
            answer++;
        }

        return priorityQueue.peek() < K ? -1 : answer;
    }
}
