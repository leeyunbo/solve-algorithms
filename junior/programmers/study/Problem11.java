package junior.programmers.study;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem11 {
    public static void main(String[] args) {
        System.out.println((4 >> 1));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] dayByComplete = new int[progresses.length];

        HashMap<Integer, Integer> dayByCompleteMap = new HashMap<>();

        for(int i=0; i<progresses.length; i++) {
            dayByComplete[i] = ((100 - progresses[i]) / speeds[i]) + ((100 - progresses[i]) % speeds[i]) > 0 ? 1 : 0;
            if(i > 0 && dayByComplete[i] <= dayByComplete[i-1]) {
                dayByComplete[i] = dayByComplete[i-1];
                dayByCompleteMap.replace(dayByComplete[i-1], dayByCompleteMap.get(dayByComplete[i-1]) + 1);
            }
            else dayByCompleteMap.put(dayByComplete[i], 1);
        }

        answer = new int[dayByCompleteMap.size()];
        List<Integer> keysOfDayByCompleteMap =
                dayByCompleteMap
                        .keySet()
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());

        int j = 0;
        for(Integer i : keysOfDayByCompleteMap) {
            answer[j++] = dayByCompleteMap.get(i);
        }


        return answer;
    }

}
