package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 * 2019 KAKAO BLIND RECRUITMENT 오픈채팅방
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problem6 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        OpenChat openChat = new OpenChat();
        String[] answer = openChat.solution(record);

        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}

class OpenChat {

    public String[] solution(String[] record) {
        String[] answer;

        Queue<String> commands = new LinkedList<>();
        Queue<String> userIds = new LinkedList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        for(int i=0; i<record.length; i++) {
            String[] line = record[i].split(" ");
            switch (line[0]) {
                case "Enter" :
                    hashMap.put(line[1], line[2]);
                    commands.add(line[0]);
                    userIds.add(line[1]);
                    break;
                case "Change" :
                    hashMap.put(line[1], line[2]);
                    break;
                case "Leave" :
                    commands.add(line[0]);
                    userIds.add(line[1]);
                    break;
            }
        }

        answer = new String[commands.size()];
        int i = 0;
        while(!commands.isEmpty()) {
            String command = commands.poll();
            String userId = userIds.poll();
            String line = null;

            switch (command) {
                case "Enter" :
                    line = hashMap.get(userId)+"님이 들어왔습니다.";
                    break;
                case "Leave" :
                    line = hashMap.get(userId)+"님이 나갔습니다.";
                    break;
            }

            answer[i++] = line;

        }


        return answer;
    }
}
