package junior.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem34 {

    public static void main(String[] args) {
        Problem34 problem34 = new Problem34();
        System.out.println(Arrays.toString(problem34.solution(new String[]{"A", "B" ,"B", "C", "A", "B", "C", "A","B","C"})));
    }

    public int[] solution(String[] gems) {
        int left = 0, right = 0, min = 654321;
        int kinds = getKindsByGems(gems);

        HashMap<String, Integer> gemsMap = new HashMap<>();
        PriorityQueue<int[]> areas = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        gemsMap.put(gems[0], 1);
        while(right < gems.length) {
            if(gemsMap.size() == kinds && min > (right - left)) {
                min = right - left;
                areas.clear();
                areas.add(new int[] {left + 1, right + 1});
            }

            if(gemsMap.size() == kinds && gemsMap.get(gems[left]) > 1) {
                gemsMap.put(gems[left], gemsMap.get(gems[left]) - 1);
                left += 1;
            }
            else {
                right += 1;
                if(right < gems.length) gemsMap.put(gems[right], gemsMap.getOrDefault(gems[right], 0) + 1);
            }
        }

        return areas.peek();
    }

    private Integer getKindsByGems(String[] gems) {
        HashMap<String, Integer> gemsMap = new HashMap<>();
        for (String gem : gems) {
            gemsMap.put(gem, gemsMap.getOrDefault(gem, 0) + 1);
        }

        return gemsMap.size();
    }
}
