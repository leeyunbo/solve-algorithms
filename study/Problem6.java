package study;

import java.util.Arrays;
import java.util.Comparator;

public class Problem6 {

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        Problem6 problem6 = new Problem6();
        problem6.solution(strings, 1);

        for(String str : strings) {
            System.out.print(str + " ,");
        }
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = strings;

        Arrays.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2) : o1.charAt(n) - o2.charAt(n);
            }
        });

        return answer;
    }

}
