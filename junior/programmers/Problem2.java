package junior.programmers;

/**
 * 연이어 짝지어진 2개의 알파벳을 지울 수 있다고 하자.
 * 모든 알파벳을 지울 수 있다면 1, 지우지 못한다면 0을 반환하시오
 */

import java.util.Stack;

public class Problem2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("baabaa"));
    }
}

class Solution {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char temp;

        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            if(stack.isEmpty()) {
                stack.add(s.charAt(i));
            }
            else {
                temp = stack.peek();
                if (temp == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        if(stack.isEmpty()) return 1;
        else return 0;
    }
}
