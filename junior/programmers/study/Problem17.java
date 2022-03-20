package junior.programmers.study;

public class Problem17 {

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        System.out.println(problem17.solution(150));
    }

    public int solution(int n) {
        int[] cache = new int[n+1];
        return draw(n, cache);
    }

    private int draw(int n, int[] cache) {
        if(n <= 2) return n;
        if(cache[n] > 0) return cache[n];

        return cache[n] = (draw(n-1, cache) + draw(n-2, cache)) % 1000000007;
    }
}
