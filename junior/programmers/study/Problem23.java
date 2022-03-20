package junior.programmers.study;

import java.util.*;

public class Problem23 {

    public static void main(String[] args) {

        Problem23 problem23 = new Problem23();
        System.out.println(problem23.solution(new int[]{70,50,80,50}, 100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int i = 0, j = people.length-1;
        while(i<j) {
            if(people[i] + people[j] <= limit) i++;
            j--;
            answer++;
        }

        return i==j ? answer+1 : answer;
    }
}

