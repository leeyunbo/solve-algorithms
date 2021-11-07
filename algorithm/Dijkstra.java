package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    private static int[][] adjArray;
    private static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        adjArray = new int[count+1][count+1];
        distance = new int[count+1];
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
        boolean[] check = new boolean[adjArray.length+1];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=1; i<distance.length; i++) {
            distance[i] = adjArray[start][i];
        }

        queue.add(start);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            check[u] = true;
            LinkedList<Integer> connectedNodes = findConnectedNode(u);
            System.out.println("connectedNodes = " + connectedNodes);
            for(int node : connectedNodes) {
                if(!check[node]) {
                    distance[node] = Math.min(distance[node], distance[u] + adjArray[u][node]);
                    System.out.println("node = " + node);
                    queue.add(node);
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
