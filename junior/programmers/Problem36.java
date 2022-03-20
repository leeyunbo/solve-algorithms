package junior.programmers;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Stack;

public class Problem36 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrInput = br.readLine().split(" ");

        int[] prices = Arrays.stream(arrInput)
                .mapToInt(Integer::parseInt)
                .toArray();

        Problem36 problem36 = new Problem36();
        System.out.println(Arrays.toString(problem36.solution(prices)));
    }

    public int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[i] > prices[j])
//                    break;
//                answer[i]++;
//            }
//        }
//        return answer;

        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length-1; i++) {
            stack.push(i);
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i+1]) {
                int target = stack.pop();
                answer[target] = i-target+1;
            }
        }

        for(int i=0; i<answer.length; i++) {
            if(answer[i] == 0) {
                answer[i] = answer.length - i - 1;
            }
        }

        return answer;
    }
}
