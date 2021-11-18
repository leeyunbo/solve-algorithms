package street11;

import java.util.*;

public class Problem2 {
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.solution(new int[] {1,1,1,1,3,3,4,4,4,4,4}));
        System.out.println(problem2.solution(new int[] {1,3,3,4,4,4,5,5,5,5}));
    }

    public int solution(int[] A) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        int largestNumber = 0;
        for (int j : A) {
            if(!hashMap.containsKey(j)) numbers.add(j);
            hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
        }

        dfs(0, 0, numbers, hashMap);
        return min;
    }

    private void dfs(int total, int idx, List<Integer> numbers, HashMap<Integer, Integer> hashMap) {
        if(idx == numbers.size()) {
            min = Math.min(total , min);
            return;
        }

        int number = numbers.get(idx);
        int count = hashMap.get(number);

        if(count == number) {
            dfs(total, idx+1, numbers, hashMap);
        }
        else {
            hashMap.put(number, number);
            if(isAdd(number, numbers, hashMap) && number > count) {
                dfs(total + (number - count), idx+1, numbers, hashMap);
            }
            else if(number < count){
                dfs(total + (count - number), idx+1, numbers, hashMap);
            }
            hashMap.put(number, count);

            hashMap.put(number, 0);
            dfs(total + count, idx+1, numbers, hashMap);
            hashMap.put(number, count);
        }
    }

    private boolean isAdd(int number, List<Integer> numbers, HashMap<Integer, Integer> hashMap) {
        boolean isLeft = true;
        boolean isRight = true;
        for(int temp : numbers) {
            if(temp == number) break;
            if(hashMap.get(temp) > 0) {
                isLeft = false;
                break;
            }
        }

        for(int i=numbers.size()-1; i>=0; i--) {
            if(numbers.get(i) == number) break;
            if(hashMap.get(numbers.get(i)) > 0) {
                isRight = false;
                break;
            }
        }

        return isLeft || isRight;
    }
}
