package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    private static int[][] adjArray;
    private static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        adjArray = new int[999][999];
        distance = new int[999];
        for(int i=0; i<count; i++) {
            String[] arr = br.readLine().split(" ");
            int u = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);
            int w = Integer.parseInt(arr[2]);
            adjArray[u][v] = w;
            adjArray[v][u] = w;
        }

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(1);

        System.out.println(Arrays.toString(distance));
    }

    private void dijkstra(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        queue.add(new int[]{start, 0});
        while(!queue.isEmpty()) {
            int[] u = queue.poll();
            if(distance[u[0]] < u[1]) continue;
            LinkedList<Integer> connectedNodes = findConnectedNode(u[0]);
            for(int v : connectedNodes) {
                if(distance[v] > distance[u[0]] + adjArray[u[0]][v]) {
                    distance[v] =  distance[u[0]] + adjArray[u[0]][v];
                    queue.add(new int[]{v, distance[v]});
                }
            }
        }
    }

    private LinkedList<Integer> findConnectedNode(int u) {
        LinkedList<Integer> connectedNodes = new LinkedList<>();
        int[] adjLine = adjArray[u];
        for(int i=1; i<adjLine.length; i++) {
            if(adjLine[i] != 0) connectedNodes.add(i);
        }
        return connectedNodes;
    }
}
