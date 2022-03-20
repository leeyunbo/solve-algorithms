package junior.programmers;

public class Problem27 {
    public static void main(String[] args) {
        Problem27 problem27 = new Problem27();
        System.out.println(problem27.solution(	8, 4, 7));
    }

    public int solution(int n, int a, int b) {
        int answer = 1;

        while(true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            if(a == b) break;
            answer++;
        }

        return answer;
    }
}
