package algorithm;

import java.util.Arrays;

public class BellmanFord {

    private static final int INF = 654321;
    private static int[][] adjArray = new int[][] {
            {0, -4, 5, 2, 3},
            {INF, 0, INF, -1, INF},
            {INF, INF, 0, -7, INF},
            {INF, INF, INF, 0, 6},
            {INF, INF, INF, -4, 0},
    };
    private static int[] distance = new int[adjArray.length];

    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.bellmanFord(0);
    }

    private void bellmanFord(int start) {
        Arrays.fill(distance, INF);
        distance[start] = 0;

        for(int i=0; i<adjArray.length; i++) {
            for(int j=0; j<adjArray[0].length; j++) {
                if(adjArray[i][j] != INF) {
                    distance[j] = Math.min(distance[i], distance[i] + adjArray[i][j]);
                }
            }
        }

        System.out.println(Arrays.toString(distance));
    }
}
