package inflearn;

import java.util.Scanner;

/*
 N개의 정수로 이루어진 수열에 대해 서로 인접해 있는 두 수의 차가 1에서 N-1까지의 값을 모두 가지면 그 수열을 유쾌한 점퍼(jolly jumper)라고 부른다.
 예를 들어 다음과 같은 수열에 서 1 4 2 3 앞 뒤에 있는 숫자 차의 절대 값이 각각 3 ,2, 1이므로 이 수열은 유쾌한 점퍼가 된다.
 어떤 수열이 유쾌한 점퍼인지 판단할 수 있는 프로그램을 작성하라.

▣ 입력설명
첫 번째 줄에 자연수 N(3<=N<=100)이 주어진다.
그 다음 줄에 N개의 정수가 주어진다.
정수의 크기는 int 형 범위안에 있으며, 인접한 두 수의 차도 정수형 범위에 있습니다.
▣ 출력설명
유쾌한 점퍼이면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력한다.
 */

public class Problem23 {

    public static void main(String[] args) {
        int N;
        int[] numbers;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = sc.nextInt();
        }

        JollyJumpers jumpers = new JollyJumpers(numbers);
        if(jumpers.mainLogic()) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }


    }
}

class JollyJumpers {
    int[] numbers;
    boolean[] checked;

    public JollyJumpers(int[] _numbers) {
        numbers = _numbers;
        checked = new boolean[numbers.length];
    }

    boolean mainLogic() {
        for(int i=1; i<numbers.length; i++) {
            int temp = Math.abs(numbers[i] - numbers[i-1]);
            // 무조건 N-1개의 값이 나와야하므로 하나의 값이라도 조건에서 벗어나게 되면 Jolly Jumpers가 될 수 없다
            if(temp > numbers.length - 1) {
                return false;
            }
            else if(checked[temp] == true){
                return false;
            }
            else {
                checked[temp] = true;
            }
        }

        return true;
    }

}
