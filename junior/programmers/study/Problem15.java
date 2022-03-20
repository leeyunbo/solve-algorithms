package junior.programmers.study;

import java.util.Arrays;

public class Problem15 {

    public static void main(String[] args) {

    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return true;
    }
}
