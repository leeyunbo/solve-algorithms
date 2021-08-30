/**
https://programmers.co.kr/learn/courses/30/lessons/49191
*/

package programmers;

import java.util.*;

public class Problem26 {
    public static void main(String[] args) {
        Problem26 problem26 = new Problem26();
        System.out.println(problem26.solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results) {
        ArrayList<LinkedList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++) adjList.add(new LinkedList<>());
        for(int[] result : results) adjList.get(result[0]).add(result[1]);

        int[] defeat = new int[n+1];

        for(int i=1; i<=n; i++) {
            bfs(i, defeat, adjList);
        }

        return cntConfirmed(defeat, n);
    }

    private void bfs(int first, int[] defeat, ArrayList<LinkedList<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(first);
        while(!queue.isEmpty()) {
            int start = queue.poll();
            for(int end : adjList.get(start)) {
                queue.add(end);
                defeat[end] += 1;
            }
        }
    }

    private int cntConfirmed(int[] defeat, int n) {
        int cnt = 0;

        int[] defeatCnt = new int[n+1];
        for(int i=0; i<=n; i++) defeatCnt[defeat[i]]++;

        for(int i=0; i<=n; i++) {
            if(defeatCnt[i] == 1) cnt++;
            else break;
        }

        if(cnt == n) return cnt;

        for(int i=n; i>=0; i--) {
            if(defeatCnt[i] == 1) cnt++;
            else break;
        }

        return cnt;
    }
}
