// 다음과 같이 import를 사용할 수 있습니다.
import java.util. *;
class Main {
    public int solution(int n, int[][] garden) { // 여기에 코드를 작성해주세요.
        int answer = 1;
        int total = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (garden[i][j] == 1) 
                    total ++;
                
            }
        }
        while (total != n * n) {
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (garden[i][j] == answer) 
                        total += check(i, j, garden, answer);
                    
                }
            }
            answer ++;
        }
        return answer - 1;
    }
    public int check(int i, int j, int[][] garden, int day) {
        int check = 0;
        if (i - 1 >= 0 && garden[i - 1][j] == 0) {
            garden[i - 1][j] = day + 1;
            check ++;
        }
        if (i + 1 < garden.length && garden[i + 1][j] == 0) {
            garden[i + 1][j] = day + 1;
            check ++;
        }
        if (j - 1 >= 0 && garden[i][j - 1] == 0) {
            garden[i][j - 1] = day + 1;
            check ++;
        }
        if (j + 1 < garden.length && garden[i][j + 1] == 0) {
            garden[i][j + 1] = day + 1;
            check ++;
        }
        return check;
    }
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int n1 = 3;
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(n1, garden1);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        int n2 = 2;
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(n2, garden2);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
