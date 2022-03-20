package junior.programmers.study;

import java.util.Arrays;

/**
 * Problem18을 그리디로 풀어봅시다.
 */

public class Problem19 {

    public static void main(String[] args) {
        Problem19 problem19 = new Problem19();
        System.out.println(problem19.solution(5, new int[] {2, 4}, new int[] {1,3,5}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] cntOfClothes = new int[n+1];
        Arrays.fill(cntOfClothes, 1);

        for(int i=0; i<lost.length; i++) {
            cntOfClothes[lost[i]]--;
        }

        for(int i=0; i<reserve.length; i++) {
            cntOfClothes[reserve[i]]++;
        }

        for(int i=1; i<cntOfClothes.length; i++) {
            if(cntOfClothes[i] == 2) {
                if(i!=0 && cntOfClothes[i-1] == 0)
                    cntOfClothes[i-1] = cntOfClothes[i] = 1;
                else if(i != (cntOfClothes.length-1) && cntOfClothes[i+1] == 0)
                    cntOfClothes[i+1] = cntOfClothes[i] = 1;
            }
        }

        for(int i=1; i<cntOfClothes.length; i++) {
            if(cntOfClothes[i] > 0) answer++;
        }

        return answer;
    }
}
