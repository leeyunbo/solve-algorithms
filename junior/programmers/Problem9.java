package junior.programmers;

import java.math.BigInteger;

public class Problem9 {

    public static void main(String[] args) {

    }

    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w,h));
    }

    public int gcd(int a,int b){
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
}
