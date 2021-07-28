package study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
 *
 * 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
 * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
 * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
 * 이전에 등장했던 단어는 사용할 수 없습니다.
 * 한 글자인 단어는 인정되지 않습니다.
 * 다음은 3명이 끝말잇기를 하는 상황을 나타냅니다.
 *
 * tank → kick → know → wheel → land → dream → mother → robot → tank
 *
 * 위 끝말잇기는 다음과 같이 진행됩니다.
 *
 * 1번 사람이 자신의 첫 번째 차례에 tank를 말합니다.
 * 2번 사람이 자신의 첫 번째 차례에 kick을 말합니다.
 * 3번 사람이 자신의 첫 번째 차례에 know를 말합니다.
 * 1번 사람이 자신의 두 번째 차례에 wheel을 말합니다.
 * (계속 진행)
 * 끝말잇기를 계속 진행해 나가다 보면, 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던 단어이므로 탈락하게 됩니다.
 *
 * 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.
 */

public class Problem3 {
    public static void main(String[] args) {
        String[] words = {"tank", "kick", "kello", "tank"};
        int n = 10;

        Problem3 problem3 = new Problem3();
        int[] answer = problem3.solution(n, words);

        System.out.println(answer[0] + "," + answer[1]);
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<Player> players = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>();

        for(int i=0; i<n; i++) {
            players.add(new Player(i+1));
        }

        Player first = players.get(0);
        first.addRound();
        wordSet.add(words[0]);
        if(words[0].length() <= 1) {
            answer[0] = first.getNumber();
            answer[1] = first.getRound();
            return answer;
        }

        for(int i = 1; i < words.length; i++) {
            Player temp = players.get(i%n);

            temp.addRound();
            if(!isPass(words[i-1], words[i], wordSet)) {
                answer[0] = temp.getNumber();
                answer[1] = temp.getRound();
                break;
            }

            wordSet.add(words[i]);
        }

        return answer;
    }

    private boolean isPass(String beforeWord, String tempWord, HashSet<String> wordSet) {
        return tempWord.charAt(0) == beforeWord.charAt(beforeWord.length()-1)
                && !wordSet.contains(tempWord)
                && tempWord.length() > 1;
    }
}

class Player {
    private int round = 0;
    private int number;

    public Player(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getRound() {
        return round;
    }

    public void addRound() {
        round++;
    }
}
