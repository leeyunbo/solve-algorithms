
import java.util.LinkedList;
import java.util.List;

/**
 * 문자열이 있다. 가변의 길이로 문자열을 나눌 때
 * s(i) = s(n-i+1)인 경우를 구하시오.
 * 가장 많은 문자열로 나누는 경우를 구하도록 한다.
 */

public class Two {

    public static void main(String[] args) {
        String s = "abcxyabcxy";

        TwoProblem twoProblem = new TwoProblem();
        String[] answer= twoProblem.solution(s);

        if(answer != null) {
            for (int i = 1; i < answer.length; i++) {
                System.out.print(answer[i] + " ");
            }
        }
    }
}


class TwoProblem {

    public String[] solution(String s) {
        String[] answer = mainLogic(s);

        return answer;
    }

    String[] mainLogic(String str) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst(null);
        if(dfs(list, str, 0)) {
            return list.toArray(new String[list.size()]);
        }
        else return null;
    }

    boolean dfs(LinkedList<String> list, String s, int startIdx) {
        if(startIdx == s.length() && list.size() > 1) {
            if(compareAll(list)) {
                return true;
            }
        }

        for(int i=1; i<s.length(); i++) {
            if(startIdx + i <= s.length()) {
                list.addLast(s.substring(startIdx, startIdx + i));
                if(compare(list, s, false)) {
                    if (dfs(list, s, startIdx + i)) return true;
                }
                list.pollLast();
            }
        }

        return false;
    }

    boolean compare(List<String> s, String str, boolean isLast) {
        int length = s.size()/2;

        int startIdx = str.length();
        for(int i=1; i<=length; i++) {
            String temp = s.get(i);
            startIdx -= temp.length();
            String other = str.substring(startIdx, startIdx+temp.length());
            if(!temp.equals(other)) {
                return false;
            }
        }
        return true;
    }

    boolean compareAll(List<String> s) {
        int n = s.size()-1;

        if(n%2==0) {
            for(int i=1; i<=(n+1)/2; i++) {
                String temp = s.get(i);
                String other = s.get(n-i+1);

                if(!temp.equals(other)) {
                    return false;
                }
            }
        }
        else {
            for(int i=1; i<(n+1)/2; i++) {
                String temp = s.get(i);
                String other = s.get(n-i+1);

                if(!temp.equals(other)) {
                    return false;
                }
            }
        }

        return true;
    }
}
