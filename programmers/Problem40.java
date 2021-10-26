/**
https://programmers.co.kr/learn/courses/30/lessons/42584
*/

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length-1; i++) {
            stack.push(i);
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i+1]) {
                int target = stack.pop();
                answer[target] = i-target+1;
            }
        }

        for(int i=0; i<answer.length; i++) {
            if(answer[i] == 0) {
                answer[i] = answer.length - i - 1;
            }
        }

        return answer;
    }
}
