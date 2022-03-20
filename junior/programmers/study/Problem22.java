package junior.programmers.study;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42897
 */

public class Problem22 {

    public static void main(String[] args) {
        Problem22 problem22 = new Problem22();
        System.out.println(problem22.solution(new int[] {1,2,3,1}));
    }

    public int solution(int[] money) {
        int[] first = new int[money.length];
        int[] second = new int[money.length];

        first[0] = money[0];
        first[1] = Math.max(money[0], money[1]);

        second[1] = money[1];
        second[2] = Math.max(money[1], money[2]);


        for(int i=2; i<money.length-1; i++) {
            first[i] = Math.max(first[i-2] + money[i], first[i-1]);
        }

        for(int i=3; i<money.length; i++) {
            second[i] = Math.max(second[i-2] + money[i], second[i-1]);
        }


        return Math.max(first[money.length-2], second[money.length-1]);
    }
}
