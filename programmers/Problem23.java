/**
https://programmers.co.kr/learn/courses/30/lessons/72411
*/

package programmers;

import java.util.*;

public class Problem23 {

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        Problem23 problem23 = new Problem23();
        System.out.println(Arrays.toString(problem23.solution(orders, course)));
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        List<HashMap<String, Integer>> menuMapList = new ArrayList<>();

        for(int i=0; i<=course[course.length-1]; i++) {
            menuMapList.add(new HashMap<>());
        }

        for(String order : orders) {
            for(int cnt : course) {
                dfs(0, cnt, order, "", menuMapList.get(cnt));
            }
        }

        for(int cnt : course) {
            HashMap<String, Integer> menuMap = menuMapList.get(cnt);
            if(menuMap.size() > 0) {
                int max = menuMap.values().stream().mapToInt(x -> x).max().getAsInt();
                if (max != 1) {
                    for (String key : menuMap.keySet()) {
                        if (menuMap.get(key) == max) answerList.add(key);
                    }
                }
            }
        }

        return answerList.stream().sorted().toArray(String[]::new);
    }

    private void dfs(int seq, int cnt, String order, String menu, HashMap<String, Integer> menuMap) {
        if(menu.length() == cnt) {
            String generalizationMenu = generalizeMenu(menu);
            menuMap.put(generalizationMenu, menuMap.getOrDefault(generalizationMenu, 0) + 1);
        }

        for(int i=seq; i<order.length(); i++) {
            dfs(i+1, cnt, order, menu+order.charAt(i), menuMap);
        }
    }

    private String generalizeMenu(String menu) {
        char[] menuArray = menu.toCharArray();
        Arrays.sort(menuArray);
        return new String(menuArray);
    }
}
