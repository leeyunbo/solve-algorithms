package junior.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */

import java.util.Stack;

public class Problem3 {

    public static void main(String[] args) {

        ZipAlgorithm zipAlgorithm = new ZipAlgorithm();
        System.out.println(zipAlgorithm.solution("abcdefghj"));

    }
}

class ZipAlgorithm {

    public int solution(String s) {
        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++) {
            String temp = zip(s, i);
            System.out.println(temp);
            answer = Math.min(answer, temp.length());
        }

        return answer;
    }

    public String zip(String s, int length) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        int i = length;
        stack.add(s.substring(0, length));
        while(true) {
            if(i + length > s.length()) {
                if(stack.size() > 0) {
                    String suffix = stack.size() == 1 ? "" : String.valueOf(stack.size());
                    sb.append(suffix + stack.peek());
                }

                sb.append(s.substring(i));
                break;
            }

            String temp = s.substring(i, i + length);
            String before = stack.peek();

            if(before.equals(temp)) {
                stack.add(temp);
                i = i + length;
            }
            else {
                String suffix = stack.size() == 1 ? "" : String.valueOf(stack.size());
                sb.append(suffix + stack.peek());
                stack.clear();
                stack.add(s.substring(i, i + length));
                i = i + length;
            }
        }

        return sb.toString();
    }
}
