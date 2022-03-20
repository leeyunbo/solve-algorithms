package junior.programmers;

public class Problem26 {
    public static void main(String[] args) {
        Problem26 problem26 = new Problem26();
        System.out.println(problem26.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] adjArray = new int[n+1][n+1];
        int[][] answers = new int[n+1][n+1];

        for (int[] result : results) adjArray[result[0]][result[1]] = 1;

        for(int m=1; m<=n; m++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    adjArray[i][j] = (adjArray[i][m] != 0 && adjArray[m][j] != 0 ? 1 : adjArray[i][j]);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            if(findCanReachNode(i, adjArray) + findReachableNode(i, adjArray) == n-1) answer++;
        }

        return answer;
    }

    private int findReachableNode(int node, int[][] adjArray) {
        int cnt = 0;
        for(int i=0; i < adjArray.length; i++) {
            cnt += adjArray[node][i];
        }
        return cnt;
    }

    private int findCanReachNode(int node, int[][] adjArray) {
        int cnt = 0;
        for(int i=0; i < adjArray.length; i++) {
            cnt += adjArray[i][node];
        }
        return cnt;
    }
}
