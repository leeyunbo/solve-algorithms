package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17676
 * 2018 KAKAO BLIND RECRUITMENT [1차] 추석 트래픽
 */

import java.util.ArrayList;

public class Problem7 {

    public static void main(String[] args) {
        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};

        HolidayTraffic holidayTraffic = new HolidayTraffic();
        System.out.println(holidayTraffic.solution(lines));
    }
}

class HolidayTraffic {

    public int solution(String[] lines) {
        int answer = 0;
        ArrayList<Request> requests = new ArrayList<>();

        answer = mainLogic(lines, requests);

        return answer;
    }

    int mainLogic(String[] lines, ArrayList<Request> requests) {
        int answer = 0, temp = 0;

        getTimes(lines, requests);

        for(int i=0; i<requests.size(); i++) {
            answer = Math.max(answer, getTraffic(requests.get(i), requests));
        }

        return answer;
    }


    int getTraffic(Request basis, ArrayList<Request> requests) {
        int cnt = 0;
        int startOfRange = basis.endTime;
        int endOfRange = startOfRange + 1000;

        for(Request request : requests) {
            if(startOfRange <= request.startTime && endOfRange >= request.startTime) {
                cnt++;
            }
            else if(startOfRange < request.endTime && endOfRange > request.endTime) {
                cnt++;
            }
            else if(startOfRange > request.startTime && endOfRange < request.endTime) {
                cnt++;
            }
        }

        return cnt;
    }

    private void getTimes(String[] lines, ArrayList<Request> requests) {
        for (String line : lines) {
            String[] log = line.split(" ");
            String[] responseTime = log[1].split(":");
            int processingTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            int startTime = 0;
            int endTime = 0;

            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
            endTime += (int) (Double.parseDouble(responseTime[2]) * 1000);  // 어차피 범위만 구하면 된다.
            startTime = endTime - processingTime + 1; // 시작 시간 = 종료 시간 - 실행시간 + 0.001초

            requests.add(new Request(startTime, endTime));
        }
    }
}


class Request {
    int startTime;
    int endTime;
    public Request(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
