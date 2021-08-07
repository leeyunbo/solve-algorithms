package study;

import java.util.Arrays;

public class Problem26 {

    public static void main(String[] args) {
        Problem26 problem26 = new Problem26();
        System.out.println(problem26.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        return dfs(0, begin, target, new boolean[words.length], words);
    }

    private int dfs(int cnt, String begin, String target, boolean[] isChecked, String[] words) {
        int answer = 654321;

        if(begin.equals(target)) return cnt;

        for(int i=0; i<words.length; i++) {
            if(!isChecked[i] && isPossible(begin, words[i])) {
                isChecked[i] = true;
                answer = Math.min(answer, dfs(cnt+1, words[i], target, isChecked, words));
                isChecked[i] = false;
            }
        }

        return answer;
    }

    private boolean isPossible(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        int cnt = 0;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) == str2.charAt(i)) cnt++;
        }

        return cnt == (str1.length()-1) ? true : false;
    }
}
