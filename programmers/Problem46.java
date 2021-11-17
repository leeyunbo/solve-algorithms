package autoever;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Problem1 {
    private static final int SNO = 0, MAJOR = 1, TEAM = 2;
    private static final HashMap<String, Integer> studentMap = new HashMap<>();
    private static final HashMap<String, ArrayList<String[]>> hashMap = new HashMap<>();

    public static void main(String[] args) {

    }


    public int solution(String[] students, int n, int m, int k) {
        int answer = 0;
        for(String student : students) {
            String[] studentInform = student.split(" ");
            if (!hashMap.containsKey(studentInform[TEAM])) {
                hashMap.put(studentInform[TEAM], new ArrayList<>());
            }
            hashMap.get(studentInform[TEAM]).add(studentInform);
            studentMap.put(studentInform[SNO], studentMap.getOrDefault(studentInform[SNO], 0) + 1);
        }

        for(String key : hashMap.keySet()) {
            if(isPossible(n, m, k, hashMap.get(key))) {
                answer += 1;
            }
        }

        return answer;
    }

    private boolean isPossible(int n, int m, int k, ArrayList<String[]> team) {
        int studentCnt = 0;
        HashSet<String> gradeSet = new HashSet<>();
        HashSet<String> majorSet = new HashSet<>();

        for (String[] student : team) {
            if (studentMap.get(student[SNO]) == 1) {
                studentCnt += 1;
                gradeSet.add(student[SNO].substring(0, 2));
                majorSet.add(student[MAJOR]);
            }
        }

        System.out.println(gradeSet);
        System.out.println(majorSet);

        if(studentCnt < n) return false;
        if(gradeSet.size() < m) return false;
        return majorSet.size() >= k;
    }
}
