/**
https://programmers.co.kr/learn/courses/30/lessons/82612
*/


class Solution {
    public long solution(int price, int money, int count) {
        return Math.max((count * (price + (long)(count * price)))/2 - money, 0); 
    }
}
