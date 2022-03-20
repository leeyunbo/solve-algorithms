package junior.inflearn;

/**
 * 1 부터 n까지의 수를 한 번씩만 사용하여 이루어진 수열이 있을 때, 1부터 n까지 각각의 수 앞에 놓여 있는 자신보다 큰 수들의 개수를 수열로 표현한 것을 Inversion Sequence라 한다.
 * 예를 들어 다음과 같은 수열의 경우 48625137
 * 1앞에 놓인 1보다 큰 수는 4, 8, 6, 2, 5. 이렇게 5개이고, 2앞에 놓인 2보다 큰 수는 4, 8, 6. 이렇게 3개,
 * 3앞에 놓인 3보다 큰 수는 4, 8, 6, 5 이렇게 4개......
 * 따라서4 8 6 2 5 1 3 7의 inversionsequence는 53402110이된다.
 * n과 1부터 n까지의 수를 사용하여 이루어진 수열의 inversion sequence가 주어졌을 때, 원래 의 수열을 출력하는 프로그램을 작성하세요.
 */

import java.util.Scanner;

public class Problem31 {

    public static void main(String[] args) {

        int n;
        int[] inversionSeq;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        inversionSeq = new int[n];
        for(int i=0; i<n; i++) {
            inversionSeq[i] = sc.nextInt();
        }


        InversionSequence sequence = new InversionSequence(n, inversionSeq);
        sequence.mainLogic();

    }
}

class InversionSequence {

    private int n;
    private int[] inversionSeq;

    public InversionSequence(int n, int[] inversionSeq) {
        this.n = n;
        this.inversionSeq = inversionSeq;
    }

    void mainLogic() {
        int[] result = new int[n];
        result[n-1] = n;

        // 1. Inversion Sequence의 맨 마지막 값은 무조건 0이다 (가장 큰 값이니까), 따라서 n-2번 반복한다.
        for(int i=inversionSeq.length-2; i>=0; i--) {
            int temp = i+1;
            int moveCnt = inversionSeq[i];

            // 1-1. 만약 자신보다 큰 값이 없으면 현재 위치에 그대로 대입한다. (큰 값들이 다 위치를 잡고 있기 떄문)
            if(moveCnt == 0) {
                result[i] = temp;
            }
            // 1-2. 자신보다 큰 값의 갯수만큼 뒤에 위치하고 있는 큰 값들을 앞으로 당기고 빈틈에 자신을 삽입한다. (위치를 찾아 데이터를 넣는 삽입 정렬의 로직과 유사)
            else {
                for(int j=i+1; j<=i+moveCnt; j++) {
                    result[j-1] = result[j];
                }
                result[i+moveCnt] = temp;
            }
        }

        print(result);

    }

    void print(int[] result) {
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
