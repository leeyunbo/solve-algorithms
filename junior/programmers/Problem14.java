package junior.programmers;

import java.util.LinkedList;

public class Problem14 {
    public static void main(String[] args) {
        String[] op = {"-", "*", "+"};
        Problem14 problem14 = new Problem14();
        problem14.dfs(new boolean[3], new LinkedList<>(), op);
    }

    private void dfs(boolean[] isCheck, LinkedList<String> priority, String[] op) {
        if(priority.size() == 3) {
            System.out.println(priority.toString());
            return;
        }

        for(int i=0; i<3; i++) {
            if(!isCheck[i]) {
                isCheck[i] = true;
                priority.offer(op[i]);
                dfs(isCheck, priority, op);
                priority.pollLast();
                isCheck[i] = false;
            }
        }
    }
}
