/**
https://programmers.co.kr/learn/courses/30/lessons/60058
*/

package programmers;

import java.util.Stack;

public class Problem21 {

    public static void main(String[] args) {
        Problem20 problem20 = new Problem20();
        System.out.println(problem20.solution("()))((()"));
    }

    public String solution(String p) {
        String u;
        String v = p;

        if(v.isEmpty()) return v;
        int perforation = divide(v);
        u = v.substring(0, perforation + 1);
        v = v.substring(perforation + 1);

        if(isOk(u)) {
            return u + solution(v);
        }
        else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(solution(v));
            sb.append(")");

            String other = u.substring(1, u.length() - 1);
            for (int j = 0; j < other.length(); j++) {
                if (other.charAt(j) == '(') sb.append(')');
                else sb.append('(');
            }

            return sb.toString();
        }

    }

    private boolean isOk(String u) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<u.length(); i++) {
            if(u.charAt(i) == '(') {
                stack.push(u.charAt(i));
            }
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private int divide(String v) {
        int left = 0, right = 0, i = 0;
        for (; i < v.length(); i++) {
            char temp = v.charAt(i);
            if (temp == '(') left++;
            else right++;
            if (left == right) break;
        }
        
        return i;
    }
}
