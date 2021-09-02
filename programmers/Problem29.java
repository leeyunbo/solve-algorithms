package programmers;

/**
https://programmers.co.kr/learn/courses/30/lessons/72412
*/

import java.util.*;

public class Problem29 {
    public static void main(String[] args) {
        Problem29 problem29 = new Problem29();
        System.out.println(Arrays.toString(problem29.solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));

    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, List<Integer>> hashMap = new HashMap<>();

        for (String s : info) {
            findAllCases("", 0, hashMap, s.split(" "));
        }

        for(String key : hashMap.keySet()) {
            Collections.sort(hashMap.get(key));
        }

        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] queryAndScore = query[i].split(" ");

            if(!hashMap.containsKey(queryAndScore[0])) continue;
            int tScore = Integer.parseInt(queryAndScore[1]);
            List<Integer> scores = hashMap.get(queryAndScore[0]);

            answer[i] = (scores.size() - findPossibleScore(scores, tScore));
        }

        return answer;
    }

    private void findAllCases(String query, int depth, HashMap<String, List<Integer>> hashMap, String[] arrInfo) {
        if(depth == 4) {
            if(!hashMap.containsKey(query)) {
                List<Integer> scores = new ArrayList<>();
                scores.add(Integer.parseInt(arrInfo[4]));
                hashMap.put(query, scores);
            } else {
                hashMap.get(query).add(Integer.parseInt(arrInfo[4]));
            }
            return;
        }
        findAllCases(query+"-", depth+1, hashMap, arrInfo);
        findAllCases(query+arrInfo[depth], depth+1, hashMap, arrInfo);
    }

    private int findPossibleScore(List<Integer> scores, int score) {
        int left = 0, right = scores.size()-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(scores.get(mid) < score) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}

