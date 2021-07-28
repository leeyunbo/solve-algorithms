package study;

import java.util.HashMap;

public class Problem10 {

    public static void main(String[] args) {
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0; i<completion.length; i++) {
            if(hashMap.containsKey(completion[i]))
                hashMap.replace(completion[i], hashMap.get(completion[i]) + 1);
            else
                hashMap.put(completion[i], 1);
        }

        for(int i=0; i<participant.length; i++) {
            if(hashMap.containsKey(participant[i]) && hashMap.get(participant[i]) > 0)
                hashMap.replace(participant[i], hashMap.get(participant[i]) - 1);
            else
                return participant[i];
        }

        return null;
    }
}
