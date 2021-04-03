package kakao;

import java.util.ArrayList;
import java.util.List;

public class Three {

    public static void main(String[] args) {

        int n = 4;
        int[][] train = {{1,2}, {1,3}, {2,4}};
        int[] passenger = {2,1,2,2};

        int[] answer;

        TrafficCalculator calculator = new TrafficCalculator(passenger, train, n);

        answer = calculator.mainLogic();

        for(int i=0; i<answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}


class TrafficCalculator {

    private List<List<Integer>> adjList = new ArrayList<>();
    private boolean[] checked;
    private int[] passenger;
    private int[][] train;
    private int n;
    private int max;
    private int maxStation;

    public TrafficCalculator(int[] _passenger, int[][] _train, int _n) {
        passenger = _passenger;
        train = _train;
        n = _n;
        checked = new boolean[passenger.length];
        initialized();
    }

    void initialized() {
        for(int i=0; i<passenger.length+1; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<train.length; i++) {
            int start = train[i][0];
            int end = train[i][1];

            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }
    }

    int[] mainLogic() {
        int[] result = new int[2];

        checked[0] = true;
        DFS(1, passenger[0]);

        result[0] = maxStation;
        result[1] = max;

        return result;
    }


    void DFS(int temp, int traffic) {

        if(max < traffic) {
            maxStation = temp;
            max = traffic;
        }
        else if(max == traffic && maxStation < temp) {
            maxStation = temp;
        }

        for(int end : adjList.get(temp)) {
            if(checked[end-1] == false) {
                checked[end-1] = true;
                DFS(end, traffic + passenger[end-1]);
                checked[end-1] = false;
            }
        }
    }
}
