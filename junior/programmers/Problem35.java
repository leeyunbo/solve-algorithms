package junior.programmers;

import java.util.*;

public class Problem35 {
    public static void main(String[] args) {
        Problem35 problem35 = new Problem35();
        System.out.println(problem35.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        Queue<String> bannedUsers = new LinkedList<>();

        for(String user : user_id) {
            for(String bannedUser : banned_id) {
                if(checkBadUser(user, bannedUser)) {
                    bannedUsers.add(bannedUser);
                }
            }
        }

        return answer;
    }

    private boolean checkBadUser(String user, String banned_id) {
        if(banned_id.length() != user.length()) return false;

        for(int i=0; i<banned_id.length(); i++) {
            if(banned_id.charAt(i) == '*') continue;
            if(banned_id.charAt(i) != user.charAt(i)) {
                return false;
            }
        }

        return false;
    }

//    private int getIndex(String bannedUser, String[] banned_id) {
//
//    }

//    private void getNumberOfCases(Queue<String> bannedUsers, String[] banned_id) {
//        int[] candidate = new int[banned_id.length];
//
//        while(!bannedUsers.isEmpty()) {
//            String bannedUser = bannedUsers.poll();
//            banned_id[getIndex(bannedUser, bannedser)] += 1;
//        }
//    }
}
