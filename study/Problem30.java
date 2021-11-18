package street11;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.solution("babaa"));
        System.out.println(problem1.solution("bbbab"));
        System.out.println(problem1.solution("bbbaaabbb"));
    }

    public int solution(String S) {
        int answer = 0;

        List<Integer> blockLengthList = getblockLengthList(S);
        blockLengthList.sort((o1, o2) -> Integer.compare(o2, o1));
        int longestLength = blockLengthList.get(0);

        System.out.println(blockLengthList);

        for(int length : blockLengthList) {
            answer += (longestLength - length);
        }

        return answer;
    }

    private List<Integer> getblockLengthList(String S) {
        List<Integer> blockLengthList = new ArrayList<>();
        char temp = S.charAt(0);
        int length = 1;
        for(int i=1; i<S.length(); i++) {
            if(temp == S.charAt(i)) {
                length += 1;
            }
            else {
                blockLengthList.add(length);
                length = 1;
                temp = S.charAt(i);
            }

            if(i==S.length()-1) {
                blockLengthList.add(length);
            }
        }

        return blockLengthList;
    }
}
