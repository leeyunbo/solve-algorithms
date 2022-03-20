package junior.programmers.study;

public class Problem25 {

    public static void main(String[] args) {
        Problem25 problem25 = new Problem25();
        System.out.println(problem25.solution(new int[] {1,1,1,1,1}, 3));
    }

    public int solution(int[] numbers, int target) {
        return dfs(0, 0, target, numbers);
    }

    private int dfs(int seq, int total, int target, int[] numbers) {
        if(seq == numbers.length && total == target) return 1;
        else if(seq == numbers.length && total != target) return 0;

        return dfs(seq+1, total+numbers[seq], target, numbers)
                + dfs(seq+1, total-numbers[seq], target, numbers);
    }
}
