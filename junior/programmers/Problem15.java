package junior.programmers;

import java.util.*;

public class Problem15 {

    public static void main(String[] args) {
        Problem15 problem15 = new Problem15();
        problem15.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

    public int[] solution(String s) {
        List<String> tuples = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<s.length()-1; i++) {
            if(s.charAt(i) == '}') {
                tuples.add(sb.toString());
                sb = new StringBuilder();
            }
            else if(s.charAt(i) != '{' && s.charAt(i-1) != '}') sb.append(s.charAt(i));
        }

        tuples.sort(Comparator.comparingInt(String::length));
        HashMap<String, Integer> elementMap = new HashMap<>();
        int[] answer = new int[tuples.size()];

        int idx=0;
        for(String tuple : tuples) {
            for(String element : tuple.split(",")) {
                if(!elementMap.containsKey(element)) {
                    elementMap.put(element, idx);
                    answer[idx++] = Integer.parseInt(element);
                    break;
                }
            }
        }

        return answer;
    }
}
