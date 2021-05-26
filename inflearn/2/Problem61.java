package inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS는 가장 가까운 노드 순으로 방문한다. 
 */

public class Problem61 {

    public static void main(String[] args) {
        int m = 6;
        ArrayList<LinkedList<Integer>> tree = new ArrayList<>();

        for(int i=0; i<=7; i++) {
            tree.add(new LinkedList<Integer>());
        }

        Scanner sc = new Scanner(System.in);


        for(int i=0; i<m; i++) {
            tree.get(sc.nextInt()).add(sc.nextInt());
        }

        BinaryTreeBfs binaryTreeBfs = new BinaryTreeBfs(tree);
        binaryTreeBfs.BFS();
    }
}

class BinaryTreeBfs {

    private ArrayList<LinkedList<Integer>> tree;

    public BinaryTreeBfs(ArrayList<LinkedList<Integer>> tree) {
        this.tree = tree;
    }

    void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int start = queue.poll();
            System.out.print(start + " ");
            for(int end : tree.get(start)) {
                queue.add(end);
            }
        }
    }
}
