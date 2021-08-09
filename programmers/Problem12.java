/**
https://programmers.co.kr/learn/courses/30/lessons/42895
*/

package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem12 {

    public static void main(String[] args) {

        Problem10 problem10 = new Problem10();
        System.out.println(problem10.solution(5, 12));
    }

    public int solution(int N, int number) {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        hashMap.put(1, new ArrayList<>());
        hashMap.get(1).add(N);


        for(int i=1; i<=8; i++) {
            hashMap.put(i, new ArrayList<>());
            hashMap.get(i).add(Integer.valueOf(hashMap.get(i-1).get(0) + "" + N));
            for(int j=1; j<i; j++) {
                for(int first : hashMap.get(j)) {
                    for(int second : hashMap.get(i-j)) {
                        if(first != 0 && second != 0) hashMap.get(i).add(first/second);
                        hashMap.get(i).add(first-second);
                        hashMap.get(i).add(first+second);
                        hashMap.get(i).add(first*second);
                    }
                }
            }
        }

        for(int i=1; i<=8; i++) {
            if (hashMap.get(i).contains(number)) return i;
        }

        return -1;
    }
}
