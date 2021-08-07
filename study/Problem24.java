package study;

import java.util.Arrays;

public class Problem24 {

    public static void main(String[] args) {
        Problem24 problem24 = new Problem24();
        System.out.println(problem24.solution(6, new int[] {7,10}));
    }

    public long solution(int n, int[] times) {
        long answer = 0;
        long min = 1;
        long max = answer = (long)times[times.length-1] * n;

        Arrays.sort(times);

        while(min <= max) {
            long cntOfPossible = 0;
            long mid = (min + max) / 2;
            for(int time : times) cntOfPossible += mid / time;
            if(cntOfPossible >= n) {
                if(mid < answer) answer = mid;
                max = mid - 1;
            }
            else min = mid + 1;
        }

        return answer;
    }
}
