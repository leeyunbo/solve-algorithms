package navercloud;

import java.util.*;

/**
 * 트럭이 다리를 건너는 문제였는데, 가장 선두에 달리는 트럭이 가장 많은 연료 소모를 하게 되고, 그 뒤에 있는 트럭들이 그것보단 적은 연료를 소모한다.
 * 1시간 마다 선두의 트럭을 교체할 수 있을 때 가장 오래 달릴 수 있는 경우의 수의 달린 시간은?
 *
 * 하나의 차라도 달릴 수 없다면 달릴 수 없다고 한다.
 */

public class Problem3 {

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.solution(new int[] {4,5,5}, 2, 1));
    }

    public int solution(int[] v, int a, int b) {
        int time = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 가장 큰 값이 맨 앞으로 오도록 한다.

        for(int i=0; i<v.length; i++) {
            priorityQueue.offer(v[i]);
        }

        while (isMove(a, b, priorityQueue)) {
            move(a, b, priorityQueue);
            time += 1;
        }

        return time;
    }

    private boolean isMove(int a, int b, PriorityQueue<Integer> priorityQueue) {
        boolean isMove = true;

        ArrayList<Integer> buffer = new ArrayList<>();
        while(!priorityQueue.isEmpty()) {
            buffer.add(priorityQueue.poll());
        }

        if(buffer.get(0) < a) isMove = false;
        for(int i=1; i<buffer.size(); i++) {
            if(buffer.get(i) < b) isMove = false;
        }

        for(int fuel : buffer) {
            priorityQueue.offer(fuel);
        }

        return isMove;
    }

    private void move(int a, int b, PriorityQueue<Integer> priorityQueue) {
        int first = priorityQueue.poll();
        priorityQueue.forEach(p -> p -= b);
        priorityQueue.offer(first - a);
    }
}
