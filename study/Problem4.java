package study;

public class Problem4 {

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};

        Problem4 problem4 = new Problem4();
        System.out.println(problem4.solution(nums));
    }

    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(isPrimeNumber(nums[i] + nums[j] + nums[k])) answer++;
                }
            }
        }

        return answer;
    }

    boolean isPrimeNumber(int n) {
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }

        return true;
    }
}
