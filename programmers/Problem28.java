/**
https://programmers.co.kr/learn/courses/30/lessons/77486
*/

package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Problem28 {

    public static void main(String[] args) {
        Problem28 problem28 = new Problem28();
        int[] answer =
                problem28.solution(new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[] {"young", "john", "tod", "emily", "mary"},
                new int[] {12, 4, 2, 5, 10});

        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        HashMap<String, String> referralMap = new HashMap<>();
        for(int i=0; i<referral.length; i++) {
            if(!referral[i].equals("-"))referralMap.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> enrollMap = new HashMap<>();
        for(int i=0; i<enroll.length; i++) {
            enrollMap.put(enroll[i], i+1);
        }

        for(int i=0; i<seller.length; i++) {
            dfs(amount[i] * 100, seller[i], answer, referralMap, enrollMap);
        }

        return answer;
    }

    private void dfs(int amount, String enroll, int[] answer, HashMap<String, String> referralMap, HashMap<String, Integer> enrollMap) {
        int pay = (int) (amount * 0.1);
        int payCutOff = (int) Math.round(amount * 0.1);

        answer[enrollMap.get(enroll)-1] += (amount - (payCutOff == 0 ? 0 : pay));

        if(payCutOff == 0 || !referralMap.containsKey(enroll)) return;

        String referral = referralMap.get(enroll);
        dfs(pay, referral, answer, referralMap, enrollMap);
    }
}
