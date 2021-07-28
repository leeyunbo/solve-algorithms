package study;

import java.util.HashMap;

public class Problem13 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        Problem13 problem13 = new Problem13();
        problem13.solution(clothes);
    }


    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            clothMap.put(clothes[i][1], clothMap.getOrDefault(clothes[i][1], 1));
        }

        for(String key : clothMap.keySet()) {
            answer *= (clothMap.get(key)+1);
        }

        return answer-1;
    }
}
