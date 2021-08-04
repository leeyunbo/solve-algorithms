package study;

public class Problem20 {

    public static void main(String[] args) {
        Problem20 problem20 = new Problem20();
        System.out.println(problem20.solution(5000));
    }

    public int solution(int n) {
        long [] cache = new long[n+1];

        cache[0] = 1;
        cache[2] = 3;

        for(int i=4; i<=n; i+=2) {
            cache[i] = cache[i-2] * cache[2] + 2;
            for(int j=i-4; j>=2; j-=2) {
                cache[i] += (cache[j] * 2);
            }

            cache[i] %= 1000000007;
        }

        return (int) cache[n];
    }
}

