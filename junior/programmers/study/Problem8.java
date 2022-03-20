package junior.programmers.study;

import java.util.Stack;

public class Problem8 {

    public static void main(String[] args) {

    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') stack.add(s.charAt(i));
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
