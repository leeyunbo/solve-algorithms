package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1835#qna
 * 2017 카카오코드 본선 - 단체사진 찍
 */

import java.util.HashMap;
import java.util.LinkedList;

public class Problem4 {

    public static void main(String[] args) {

        String[] data = {"N~F=0", "R~T>2"};
        PhotoGrapher photoGrapher = new PhotoGrapher();
        System.out.println(photoGrapher.solution(data.length, data));

    }
}

class PhotoGrapher {

    String[] people = {"A", "C", "F", "J", "M", "N", "R", "T"};
    HashMap<String, Integer> row = new HashMap<>();

    public int solution(int n, String[] data) {
        int answer;
        HashMap<String, LinkedList<Condition>> adjList = new HashMap<>();

        for(int i=0; i<people.length; i++) {
            adjList.put(people[i], new LinkedList<>());
            row.put(people[i], -1);
        }

        for(int i=0; i<data.length; i++) {
            String temp = data[i];

            String one = temp.substring(0,1);
            String two = temp.substring(2,3);
            String type = temp.substring(3,4);
            int space = Integer.parseInt(temp.substring(4));

            Condition condition1 = new Condition(space, one, type);
            Condition condition2 = new Condition(space, two, type);

            adjList.get(one).add(condition2);
            adjList.get(two).add(condition1);
        }

        answer = dfs(0, adjList, people.length);



        return answer;
    }

    int dfs(int idx, HashMap<String, LinkedList<Condition>> adjList, int n) {
        int result = 0;

        if(idx == n && check(adjList)) {
            return 1;
        }

        for(int i=0; i<n; i++) {
            if(row.get(people[i]) < 0) {
                row.replace(people[i], idx);
                result += dfs(idx+1, adjList, n);
                row.replace(people[i], -1);
            }
        }

        return result;

    }

    boolean check(HashMap<String, LinkedList<Condition>> adjList) {
        for(int i=0; i<people.length; i++) {
            LinkedList<Condition> conditions = adjList.get(people[i]);
            for(Condition condition : conditions) {
                boolean flag = false;
                int space = condition.space + 1;

                if(condition.type.equals("<")) {
                    if(Math.abs(row.get(people[i]) - row.get(condition.other)) < space) {
                        flag = true;
                    }
                }
                else if(condition.type.equals(">")) {
                    if(Math.abs(row.get(people[i]) - row.get(condition.other)) > space) {
                        flag = true;
                    }
                }
                else {
                    if(Math.abs(row.get(people[i]) - row.get(condition.other)) == space) {
                        flag = true;
                    }
                }

                if(!flag) return false;
            }
        }

        return true;
    }
}

class Condition {
    int space;
    String other;
    String type;
    public Condition(int space, String other, String type) {
        this.space = space;
        this.other = other;
        this.type = type;
    }

}
