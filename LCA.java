package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LCA {

    private static int[] parents;
    private static int[] levels;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] datas = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] tree = new int[datas.length+1];

        tree[1] = datas[0];
        for(int i=0; i<datas.length; i++) {
            tree[i+1] = datas[i];
        }

        parents = new int[datas.length+1];
        levels = new int[datas.length+1];

        LCA lca = new LCA();
        lca.initialized(tree);

        System.out.println(lca.lca(2, 7));
    }

    private void initialized(int[] tree) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        levels[1] = 0;
        parents[1] = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            int leftNode = temp*2;
            int rightNode = temp*2+1;
            if(leftNode < tree.length) {
                queue.add(leftNode);
                levels[leftNode] = levels[temp] + 1;
                parents[leftNode] = temp;
            }

            if(rightNode < tree.length) {
                queue.add(rightNode);
                levels[rightNode] = levels[temp] + 1;
                parents[rightNode] = temp;
            }
        }
    }

    private int lca(int a, int b) {
        int aDepth = levels[a];
        int bDepth = levels[b];

        while(aDepth > bDepth) {
            a = parents[a];
            aDepth--;
        }

        while(aDepth < bDepth) {
            b = parents[b];
            bDepth--;
        }

        while(a!=b) {
            a = parents[a];
            b = parents[b];
            aDepth--;
            bDepth--;
        }

        return a;
    }
}
