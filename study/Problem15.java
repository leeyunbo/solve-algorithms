package study;

import java.util.Arrays;
import java.util.HashMap;

public class Problem15 {

    public static void main(String[] args) {

    }

    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> phoneMap = new HashMap();

        for(String phone : phone_book) {
            phoneMap.put(phone, phoneMap.getOrDefault(phone, 0) + 1);
        }

        for(String phone : phone_book) {
            for(int j=1; j<phone.length(); j++) {
                if(phoneMap.containsKey(phone.substring(0, j))) return false; // O(1)
            }
        }

        return true;
    }
}
