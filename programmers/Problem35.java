/**
회의실 예약시간의 구간이 Input으로 주어질 때, 가장 많이 회의실 예약이 이루어진 시간을 반환하세요
회의실 예약 시작 시간은 +1, 종료 시간+1은 -1로 하여 겹치는 회의실의 개수를 계산한다. 
계산 한 후에 누적합을 구하면 해당 시간에 예약된 회의실의 개수를 구할 수 있다. 
*/ 

public class Problem35 {

    public static void main(String[] args) {

        int[][] schedules = {{1,3}, {2,4}, {3,5}, {1,5}, {1,6}, {4,5}};
        int[] times = new int[100000];
        int[] result = new int[100000];

        for(int i=0; i<schedules.length; i++) {
            times[schedules[i][0]] += 1;
            times[schedules[i][1] + 1] -= 1;
        }

        result[0] = times[0];
        for(int i=1; i<times.length; i++) {
            result[i] = result[i-1] + times[i];
        }

        int max = result[0];
        int idx = 0;
        for(int i=1; i<result.length; i++) {
            if(max < result[i]) {
                max = result[i];
                idx = i;
            }
        }

        System.out.println(idx);
    }


}
