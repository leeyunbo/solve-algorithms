package inflearn;

/**
 * A도시에서 출발한 기차는 B도시로 도착한다. 그런데 도로 중간에 T자형 교차로가 있어 출발한
 * 기차의 도착 순서를 조정할 수 있다.
 * 교차로에서는 다음과 같은 두 개의 작업을 합니다.
 * P(push)작업 : A도시에서 오는 기차를 교차로에 넣는다.
 * O(out)작업 : 교차로에 들어온 가장 최근 기차를 B도시로 보낸다.
 * 만약 2 1 3 기차 번호 순으로 A도시에서 출발하더라도 B도시에는 T교차로를 이용하여 1 2 3 순으로 도착하게 할 수 있습니다.
 * 그 작업 P, P, O, O, P, O순으로 작업을 하면 B도시에 1, 2, 3 순으로 도착합니다.
 * 1부터 N까지 번호를 가진 기차가 A도시에서 어떤 순으로 출발하든, B도시에 번호순으로 도착 하도록 하는 교차로 작업을 출력합니다.
 * 모든 기차는 교차로에 들어가야만 B도시로 갈 수 있습니다. 번호순서대로 도착이 불가능하면 impossible 이라고 출력합니다.
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(3<=N<=30)가 주어진다.
 * 두 번째 줄에 A도시에서 출발하는 기차번호순이 차례대로 입력된다.
 *
 * ▣ 출력설명
 * 교차로 작업을 순서대로 P와 O로 출력한다.
 */

import java.util.Scanner;
import java.util.Stack;

public class Problem50 {

    public static void main(String[] args) {
        int[] trains;
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        trains = new int[n];
        for(int i=0; i<n; i++) {
            trains[i] = sc.nextInt();
        }

        TrainSimulator simulator = new TrainSimulator(trains);
        System.out.println(simulator.simulate());
    }
}

class TrainSimulator {

    private int[] trains;

    public TrainSimulator(int[] trains) {
        this.trains = trains;
    }

    String simulate() {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        int aim = 1, i = 0;

        stack.push(trains[0]);
        answer += "P";

        while(aim <= trains.length) {
            if(stack.isEmpty()) {
                stack.push(trains[++i]);
                answer += "P";
            }

            int temp = stack.peek();
            if(temp == aim) {
                stack.pop();
                aim++;
                answer += "O";
            }
            else {
                if(i==trains.length-1) return "impossible";
                stack.push(trains[++i]);
                answer += "P";
            }
        }

        return answer;
    }
}
