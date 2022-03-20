package junior.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Problem16 {

    public static void main(String[] args) {
        Problem16 problem16 = new Problem16();
        System.out.println(problem16.solution("aa1+aa2", "AAAA12"));
        System.out.println(problem16.solution("handshake", "shake hands"));
    }

    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase(Locale.ROOT);
        str2 = str2.toUpperCase(Locale.ROOT);

        List<String> set1 = convertStringToSet(str1);
        List<String> set2 = convertStringToSet(str2);

        // hashMap을 만든다.
        HashMap<String, Integer> hashMap = convertSetToHashMap(set1);
        HashMap<String, Integer> hashMap2 = convertSetToHashMap(set2);

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        // 1. 교집합을 구한다.
        for(String key : hashMap.keySet()) {
            if(hashMap2.containsKey(key)) {
                int cnt = Math.min(hashMap2.get(key), hashMap.get(key));
                for(int i=0; i<cnt; i++) {
                    intersection.add(key);
                }
            }
        }

        // 2. 합집합을 구한다.
        for(String key : hashMap.keySet()) {
            if(hashMap2.containsKey(key)) {
                int cnt = Math.max(hashMap2.get(key), hashMap.get(key));
                for(int i=0; i<cnt; i++) {
                    union.add(key);
                }
            }
            else {
                int cnt = hashMap.get(key);
                for(int i=0; i<cnt; i++) {
                    union.add(key);
                }
            }
        }

        for(String key : hashMap2.keySet()) {
            if(!hashMap.containsKey(key)) {
                int cnt = hashMap2.get(key);
                for(int i=0; i<cnt; i++) {
                    union.add(key);
                }
            }
        }


        return (intersection.size() == 0 && union.size() == 0) ? 65536 : (int)Math.floor(((double) intersection.size()/union.size()) * 65536);
    }

    private List<String> convertStringToSet(String str) {
        List<String> set = new ArrayList<>();

        for(int i=0; i<str.length()-1; i++) {
            if((65 <= str.charAt(i) && str.charAt(i) <= 90) && 65 <= str.charAt(i+1) && str.charAt(i+1) <= 90)
                set.add(str.substring(i, i+2));
        }

        return set;
    }

    private HashMap<String, Integer> convertSetToHashMap(List<String> set) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0; i<set.size(); i++) {
            hashMap.put(set.get(i), hashMap.getOrDefault(set.get(i), 0) + 1);
        }

        return hashMap;
    }
}
