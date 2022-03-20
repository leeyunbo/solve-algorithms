package junior.programmers;

import java.util.Arrays;
import java.util.Stack;

public class Problem33 {
    public static void main(String[] args) {
        Problem33 problem33 = new Problem33();
        System.out.println(problem33.solution(8,2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
    }

    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        boolean[] isDelete = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int last = n-1;

        for(String command : cmd) {
            System.out.println(Arrays.toString(isDelete));
            String[] arrCommand = command.split(" ");
            switch (arrCommand[0]) {
                case "D" -> k = down(k, Integer.parseInt(arrCommand[1]), isDelete);
                case "U" -> k = up(k, Integer.parseInt(arrCommand[1]), isDelete);
                case "Z" -> {
                    int idx = stack.pop();
                    isDelete[idx] = false;
                    if(idx > last) last = idx;
                }
                case "C" -> {
                    isDelete[k] = true;
                    stack.push(k);
                    if (last == k) {
                        k = up(k, 1, isDelete);
                        last = k;
                    } else {
                        k = down(k, 1, isDelete);
                    }
                }
            }
        }

        for (boolean b : isDelete) {
            answer.append(b ? "X" : "O");
        }

        return answer.toString();
    }

    private int down(int k, int x, boolean[] isDelete) {
        for(int i=0; i<x; i++) {
            do k++;
            while(isDelete[k]);
        }
        return k;
    }

    private int up(int k, int x, boolean[] isDelete) {
        for(int i=0; i<x; i++) {
            do k--;
            while (isDelete[k]);
        }
        return k;
    }
}
