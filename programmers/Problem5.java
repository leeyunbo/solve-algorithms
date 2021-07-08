package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 더 맵게
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem5 {

    public static void main(String[] args) {
        int[] scovile = {1,2,3,9,10,12};
        int K = 9999;


        Scovile scoviles = new Scovile();
        System.out.println(scoviles.solution(scovile, K));

    }
}

class Scovile {
    public int solution(int[] scovile, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) return -1;
                else if(o1 > o2) return 1;
                else return 0;
            }
        });

        for(int i=0; i<scovile.length; i++)
            queue.add(scovile[i]);

        while(queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            if(first >= K) break;

            queue.add(first + second * 2);
            answer++;
            System.out.println(queue.toString());
        }

        if(queue.size() == 1 && queue.peek() >= K)
            return answer;
        else if(queue.size() == 1 && queue.peek() < K)
            return -1;
        else
            return answer;
    }
}
