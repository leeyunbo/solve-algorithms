package junior.programmers;
import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */

public class Problem13 {

    public static void main(String[] args) {
        Problem13 problem13 = new Problem13();
        System.out.println(problem13.solution("50*6-3*2"));
    }

    public long solution(String expression) {
        String[] op = {"-", "*", "+"};
        ArrayList<String> nodes = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '+')
                sb.append(expression.charAt(i));
            else {
                nodes.add(sb.toString());
                nodes.add(String.valueOf(expression.charAt(i)));
                sb = new StringBuilder();
            }
        }

        nodes.add(sb.toString());
        ArrayList<String> priority = new ArrayList<>();

        return dfs(new boolean[3], priority, op, nodes);
    }

    private long dfs(boolean[] isCheck, ArrayList<String> priority, String[] op, ArrayList<String> nodes) {
        long answer = 0;

        if(priority.size() == 3) {
            return formulaCalculation(priority, nodes);
        }

        for(int i=0; i<3; i++) {
            if(!isCheck[i]) {
                isCheck[i] = true;
                priority.add(op[i]);
                answer = Math.max(answer, Math.abs(dfs(isCheck, priority, op, nodes)));
                priority.remove(priority.size()-1);
                isCheck[i] = false;
            }
        }

        return answer;
    }

    private long formulaCalculation(List<String> priority, ArrayList<String> bNodes) {
        ArrayList<String> nodes = new ArrayList<>(bNodes);
        for(String op : priority) {
            int j = 0;
            while(nodes.contains(op)) {
                if(op.equals(nodes.get(j))) {
                    long left = Long.parseLong(nodes.get(j - 1));
                    long right = Long.parseLong(nodes.get(j + 1));
                    for (int k = 0; k < 3; k++) nodes.remove(j - 1);
                    nodes.add(j - 1, arithmeticOperation(left, right, op));
                    j = 0;
                }
                else {
                    j++;
                }
            }
        }

        return Long.parseLong(nodes.get(0));
    }

    private String arithmeticOperation(long left, long right, String oper) {
        long result = 0;

        switch (oper) {
            case "-" :
                result = left - right;
                break;
            case "+" :
                result = left + right;
                break;
            case "*" :
                result = left * right;
        }

        return String.valueOf(result);
    }
}
