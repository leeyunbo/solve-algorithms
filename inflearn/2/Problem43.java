package inflearn;

import java.util.Scanner;

/*
현수의 컴퓨터는 멀티태스킹이 가능하다. 처리해야 할 작업이 N개 들어오면 현수의 컴퓨터는
작업을 1부터 N까지의 번호를 부여하고 처리를 다음과 같이 한다.
1) 컴퓨터는 1번 작업부터 순서대로 1초씩 작업을 한다. 즉 각 작업을 1초만 작업하고 다음 작업을 하는 식이다.
2) 마지막 번호의 작업을 1초 했으면 다시 1번 작업으로 가서 다시 1초씩 후속 처리를 한다.
3) 처리가 끝난 작업은 작업 스케쥴에서 사라지고 새로운 작업은 들어오지 않는다.
그런데 현수의 컴퓨터가 일을 시작한 지 K초 후에 정전이 되어 컴퓨터가 일시적으로 멈추었다. 전기가 들어오고 나서 현수의 컴퓨터가 몇 번 작업부터 다시 시작해야 하는지 알아내는 프로그램을 작성하세요.
 */

public class Problem40 {

    public static void main(String[] args) {
        int n, k;
        int[] times;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        times = new int[n];
        for(int i=0; i<n; i++) {
            times[i] = sc.nextInt();
        }
        k = sc.nextInt();

        MultiTasking tasking = new MultiTasking(k, times);
        System.out.println(tasking.mainLogic());
    }
}

class MultiTasking {

    private int k;
    private int[] times;

    public MultiTasking(int k, int[] times) {
        this.k = k;
        this.times = times;
    }

    int mainLogic() {
        int time = 0, idx = 0, tot = 0;

        // 작업 시간의 총합이 k보다 작거나 같으면 모든 작업이 정전 전에 마무리 될 수 있다.
        for(int i=0; i<times.length; i++) {
            tot += times[i];
        }

        if(tot <= k) return -1;

        while(time < k) {
            // 현재 작업이 모두 수행이 완료 되었다면 다음 작업으로 바로 넘어간다.
            if(times[idx] == 0) {
                idx++;
                continue;
            }

            // 현재 작업을 수행한다.
            times[idx]--;
            time++;

            // 다음 작업으로 넘어간다.
            idx++;
            if(idx == times.length) idx = 0;
        }

        // 종료되지 않은 작업이 존재한다면 정전이 종료된 후에 바로 실행될 작업을 찾는다.
        while(times[idx] == 0) {
            idx++;
            if(idx == times.length) {
                idx = 0;
            }
        }

        return idx+1;
    }
}
