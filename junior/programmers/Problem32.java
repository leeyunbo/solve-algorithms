package junior.programmers;

import java.util.*;

public class Problem32 {
    public static void main(String[] args) {
        Problem32 problem32 = new Problem32();
        System.out.println(problem32.solution(10, 60, 45, new String[] {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
        System.out.println(problem32.solution(1, 1, 5, new String[] {"00:01", "00:01", "00:01", "00:01", "00:01"}));
    }

    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;

        List<Integer> personList = new ArrayList<>();
        List<Integer> busList = new ArrayList<>();

        int timeForBus = convertToSec("09:00");
        for(int i=1; i<=n; i++) {
            busList.add(timeForBus);
            timeForBus += (t * 60);
        }

        for(String time : timetable) {
            int timeForPerson = convertToSec(time);
            personList.add(timeForPerson);
        }

        personList.sort(Integer::compareTo);
        boolean[] check = new boolean[personList.size()];

        for(Integer bus : busList) {
            LinkedList<Integer> queue = new LinkedList<>();
            for(int i=0; i<personList.size(); i++) {
                if(queue.size() == m) break;
                if(!check[i] && bus >= personList.get(i)) {
                    queue.add(personList.get(i));
                    check[i] = true;
                }
            }

            if(queue.size() < m) answer = bus;
            else if(queue.size() == m) answer = queue.pollLast() - 60;
        }

        return convertToStrTime(answer);
    }

    private int convertToSec(String time) {
        String[] arrTime = time.split(":");
        int hour = Integer.parseInt(arrTime[0]);
        int minute = Integer.parseInt(arrTime[1]);

        return hour * 3600 + minute * 60;
    }

    private String convertToStrTime(int time) {
        int hour = time / 3600;
        int minute = (time % 3600) / 60;

        String strHour = String.valueOf(hour).length() == 1 ? "0" + hour : String.valueOf(hour);
        String strMinute = String.valueOf(minute).length() == 1 ? "0" + minute : String.valueOf(minute);
        return strHour + ":" + strMinute;
    }
}
