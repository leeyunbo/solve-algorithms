package junior.programmers.study;

public class Problem9 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length-1; i++) {
            for(int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}
