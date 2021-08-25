package programmers;

public class Problem24 {

    public static void main(String[] args) {
        Problem24 problem24 = new Problem24();
        System.out.println(problem24.solution("AaAaAcA").trim());
    }

    public String solution(String sentence) {
        return dfs("", sentence);
    }

    boolean isSmall(char temp) {
        return 97 <= temp && temp <= 122;
    }

    String dfs(String answer, String part) {
        if(isSmall(part.charAt(0))) {
            int rightIdx = part.lastIndexOf(part.charAt(0));
            if(rightIdx == 0) return "invalid";
            if(cntSameCharacter(part, part.charAt(0)) > 2) return "invalid";
            String next = part.substring(1, rightIdx);
            if(isOneCondition(next, part.charAt(0))) return dfs(answer + createCorrectSentence(next) + " ", part.substring(rightIdx+1));
        }
        else {
            String nextAnswer = "invalid";
            if(isSmall(part.charAt(1))) {
                int nextIdx = part.lastIndexOf(part.charAt(1))+2;
                String next = part.substring(0, nextIdx);
                if(isTwoCondition(next, part.charAt(1))) nextAnswer = dfs(answer + createCorrectSentence(next), part.substring(nextIdx));
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

    boolean isOneCondition(String part, char target) {
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
            if((small && !isSmall(part.charAt(i)))
                    || (!small && isSmall(part.charAt(i)))) return false;
            if((part.charAt(i) != target)) return false;
            small =! small;
        }
        return true;
    }
}
