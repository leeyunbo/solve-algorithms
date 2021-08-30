/**
https://programmers.co.kr/learn/courses/30/lessons/49191
*/

package programmers;

import java.util.*;

public class Problem26 {
    public static void main(String[] args) {
        Problem26 problem26 = new Problem26();
        System.out.println(problem26.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<LinkedList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new LinkedList<>());
        for (int[] result : results) adjList.get(result[0]).add(result[1]);

        for(int i=1; i<=n; i++) {
            int temp = cntReachableNode(i, adjList) + cntCanReachableNode(i, adjList);
            if(temp == n-1) answer += 1;
\        }

        return answer;
    }

    private int cntReachableNode(int node, ArrayList<LinkedList<Integer>> adjList) {
        int cnt = 0;
        for(int i=1; i<adjList.size(); i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            boolean finish = false;
            while(!queue.isEmpty()) {
                int start = queue.poll();
                for(int end : adjList.get(start)) {
                    if(end == node) {
                        cnt++;
                        finish = true;
                        break;
                    }
                    queue.add(end);
                }
                if(finish) break;
            }
        }

        return cnt;
    }

    private int cntCanReachableNode(int node, ArrayList<LinkedList<Integer>> adjList) {
        int cnt = 0;
        boolean[] check = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int start = queue.poll();
            for(int end : adjList.get(start)) {
                if(!check[end]) {
                    queue.add(end);
                    check[end] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

