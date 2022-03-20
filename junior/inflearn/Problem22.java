package junior.inflearn;

/*
N개의 숫자가 나열된 수열이 주어집니다. 이 수열 중 연속적으로 증가하는 부분 수열을 최대 길이를 구하여 출력하는 프로그램을 작성하세요.
만약 N=9이고
5 7 3 3 12 12 13 10 11 이면 “3 3 12 12 13”부분이 최대 길이 증가수열이므로 그 길이인 5을 출력합니다.
값이 같을 때는 증가하는 걸로 생각합니다.
 */

import java.util.Scanner;

public class Problem22 {

    public static void main(String[] args) {
        int[] seq;
        int N;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        seq = new int[N];
        for(int i=0; i<N; i++) {
            seq[i] = sc.nextInt();
        }

        LIS lis = new LIS(seq);
        int result = lis.lisMainLogic();
        System.out.println(result);
    }
}


class LIS {

    int[] seq;

    public LIS(int[] _seq) {
        seq = _seq;
    }

    int lisMainLogic() {

        int l = 1, before = seq[0], max = 1;
        for(int i=1; i<seq.length; i++) {
            if(before <= seq[i]) {
                l++;
                max = Math.max(l, max);
            }
            else {
                l=1;
            }

            before = seq[i];
        }

        return max;
    }
}
