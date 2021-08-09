/**
https://programmers.co.kr/learn/courses/30/lessons/62048
*/

import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w,h));
    }

    public int gcd(int a,int b){
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
}
