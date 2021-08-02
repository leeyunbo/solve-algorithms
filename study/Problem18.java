package study;

import java.util.LinkedList;
import java.util.Queue;

public class Problem18 {

    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        System.out.println(problem18.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] isLost = new boolean[n+1];
        Queue<Integer> reserveQueue = new LinkedList<>();
        int ok = n;

        for(int i=0; i<lost.length; i++) {
            isLost[lost[i]] = true;
            ok--;
        }

        for(int i=0; i<reserve.length; i++) {
            if(isLost[reserve[i]]) {
                isLost[reserve[i]] = false;
                ok++;
                continue;
            }

            reserveQueue.offer(reserve[i]);
        }

        return dfs(isLost, reserveQueue, ok);
    }

    private int dfs(boolean[] isLost, Queue<Integer> reserveQueue, int ok) {
        if(reserveQueue.isEmpty()) return ok;

        int answer = 0;
        int reserve = reserveQueue.peek();
        if(reserve != 1 && isLost[reserve-1]) {
            isLost[reserve-1] = false;
            reserveQueue.poll();
            answer = Math.max(answer, dfs(isLost, reserveQueue, ok+1));
            reserveQueue.offer(reserve);
            isLost[reserve-1] = true;
        }

        if(reserve < isLost.length-1 && isLost[reserve+1]) {
            isLost[reserve+1] = false;
            reserveQueue.poll();
            answer = Math.max(answer, dfs(isLost, reserveQueue, ok+1));
            reserveQueue.offer(reserve);
            isLost[reserve+1] = true;
        }

        return answer;
    }
}
