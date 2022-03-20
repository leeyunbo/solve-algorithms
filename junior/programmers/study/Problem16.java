package junior.programmers.study;

import java.util.LinkedList;
import java.util.List;

public class Problem16 {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};

        Problem16 problem16 = new Problem16();
        System.out.println(problem16.solution(n , computers));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[computers.length];
        List<LinkedList<Integer>> adjList = new LinkedList<>();

        for(int i=0; i<computers.length; i++) {
            adjList.add(new LinkedList<>());
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) adjList.get(i).add(j);
            }
        }

        for(int i=0; i<computers.length; i++) {
            if(check[i] == false) answer += dfs(i, adjList, check);
        }

        return answer;
    }


    private int dfs(int n, List<LinkedList<Integer>> adjList, boolean[] check) {
        int result = 0;
        check[n] = true;

        for(int next : adjList.get(n)) {
            if(check[next] == false) dfs(next, adjList, check);
        }

        return 1;
    }
}
