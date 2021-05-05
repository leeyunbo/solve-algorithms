// 다음과 같이 import를 사용할 수 있습니다.
import java.util. *;
class Main {
    public int solution(int[] arr) { // 여기에 코드를 작성해주세요.
        int answer = 0;
        int left = 0;
        int right = 1;
        while (right < arr.length) {
            if (arr[right] <= arr[right - 1]) {
                left = right;
            } else {
                answer = Math.max(answer, right - left + 1);
            }
            right ++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main sol = new Main();
        int[] arr = {
            3,
            1,
            2,
            4,
            5,
            1,
            2,
            2,
            3,
            4
        };
        int ret = sol.solution(arr);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
