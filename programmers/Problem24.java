/**
https://programmers.co.kr/learn/courses/30/lessons/1830#qna
*/
package programmers;

public class Problem24 {

    public static void main(String[] args) {
        Problem24 problem24 = new Problem24();
        System.out.println(problem24.solution("xAaAbAaAx").trim());
        //AaAaAcA
    }

    public String solution(String sentence) {
        for(int i=0; i<sentence.length(); i++) {
            if(sentence.charAt(i) == ' ') return "invalid";
        }
        return dfs("", sentence).trim();
    }

    boolean isSmall(char temp) {
        return 97 <= temp && temp <= 122;
    }

    String dfs(String answer, String part) {
        if(part.length() == 0) return answer;

        //GbWbFbD
        if(isSmall(part.charAt(0))) {
            int rightIdx = part.lastIndexOf(part.charAt(0));
            if(rightIdx == 0) return "invalid";
            if(cntSameCharacter(part, part.charAt(0)) != 2) return "invalid";
            String next = part.substring(1, rightIdx);
            if(isOneCondition(next)) {
                return dfs(answer + createCorrectSentence(next) + " ", part.substring(rightIdx+1));
            }
            else {
                if(isSmall(part.charAt(1))) return "invalid";
                return dfs(answer, part.substring(1, rightIdx) + part.substring(rightIdx+1));
            }
        }
        else {
            String nextAnswer = "invalid";
            int nextIdx = 0;
            if(part.length() > 1) nextIdx = part.lastIndexOf(part.charAt(1))+2;
            if(part.length() > 1 && nextIdx <= part.length() && isSmall(part.charAt(1))) {
                String next = part.substring(0, nextIdx);
                if(isTwoCondition(next, part.charAt(1))) nextAnswer = dfs(answer + createCorrectSentence(next) + " ", part.substring(nextIdx));
                if(!nextAnswer.equals("invalid")) return nextAnswer;

                nextAnswer = dfs(answer + part.charAt(0) + " ", part.substring(1));
                if(!nextAnswer.equals("invalid")) return nextAnswer;
            }
            else {
                return dfs(answer + part.charAt(0) + " ", part.substring(1));
            }
        }

        return "invalid";
    }

    int cntSameCharacter(String part, char target) {
        int cnt = 0;
        for(int i=0; i<part.length(); i++) {
            if(target == part.charAt(i)) cnt++;
        }
        return cnt;
    }

    String createCorrectSentence(String part) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<part.length(); i++) {
            if(!isSmall(part.charAt(i))) sb.append(part.charAt(i));
        }
        return sb.toString();
    }

    boolean isOneCondition(String part) {
        //GbWbFbD
        if(part.length()==0) return false;
        if(part.length()==1 && isSmall(part.charAt(0))) return false;
        if(part.length()==1 && !isSmall(part.charAt(0))) return true;

        char target = part.charAt(1);
        if(part.equals("")) return false;
        if(isTwoCondition(part, target)) return true;
        for(int i=0; i<part.length(); i++) {
            if(isSmall(part.charAt(i))) return false;
        }
        return true;
    }

    boolean isTwoCondition(String part, char target) {
        boolean small = false;
        for(int i=0; i<part.length(); i++) {
            if((small && !isSmall(part.charAt(i))) || (!small && isSmall(part.charAt(i)))) return false;
            if(small && (part.charAt(i) != target)) return false;
            small =! small;
        }
        return true;
    }
}
