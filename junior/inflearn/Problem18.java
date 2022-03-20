package junior.inflearn;

import java.util.Scanner;

/*
오늘은 수능이 끝난 다음날로 교장선생님은 1, 2학년 재학생들에게 강당에 모여 어벤져스 영 화를 보여준다고 하여 학생들이 강당에 모였습니다.
강당의 좌석은 영화관처럼 계단형이 아니라 평평한 바닥에 의자만 배치하고 학생들이 앉습니 다.
그런데 만약 앞자리에 앉은 키가 큰 학생이 앉으면 그 학생보다 앉은키가 작은 뒷자리 학 생은 스크린이 보이지 않습니다.
한 줄에 앉은키 정보가 주어지면 뒷사람 모두의 시야를 가려 영화 시청이 불가능하게 하는 분노유발자가 그 줄에 몇 명이 있는지 구하는 프로그램을 작성 하세요.
 */

public class Problem18 {

    public static void main(String[] args) {
        int N, result;
        int[] heights;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        heights = new int[N];
        for(int i=0; i<N; i++) {
            heights[i] = sc.nextInt();
        }

        PickRageInducingModule module = new PickRageInducingModule(heights);
        result = module.bestCountRageInducing();
        System.out.println(result);

    }
}

class PickRageInducingModule {

    int[] heights;

    public PickRageInducingModule(int[] _heights) {
        heights = _heights;
    }

    int countRageInducing() {
        int temp, result = 0, i = 0;
        boolean flag;

        // 1. 구타 유발자면 다음 인덱스로 넘어간다. (i++)
        // 2. 어떤 특정 값이 기준 값보다 크면, 그 특정 값의 인덱스로 넘어간다. (i=j)
        // 3. i < heights.length-1 == false면 종료한다.

        while(i < heights.length-1) {
            flag = true;
            temp = heights[i];
            for(int j=i+1; j<heights.length; j++) {
                if(temp < heights[j]) {
                    flag = false;
                    i = j;
                    break;
                }
            }

            if(flag) {
                result++;
                i++;
            }
        }

        return result;
    }

    int bestCountRageInducing() {
        // 1. 배열 뒤에서부터 앞으로 전진한다.
        // 2. 앞의 값이 뒤의 값들의 최대값보다 크면 구타 유발자인 동시에 최대값이다.
        // 3. 위의 과정을 반복하면 구타 유발자를 모두 구할 수 있다.


        int result = 0;
        int max = heights[heights.length-1];

        for(int i=heights.length-2; i>=0; i--) {
            if(max < heights[i]) {
                result++;
                max = heights[i];
            }
        }

        return result;

    }
}
