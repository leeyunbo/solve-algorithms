package leetcode.easy.numericalcalculation;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumSolution {
    public static void main(String[] args) {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        System.out.println(Arrays.toString(twoSumSolution.twoSum(new int[]{3, 3}, 6)));
    }

    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int find = target - nums[i];
            if(hashMap.containsKey(find)) {
                return new int[] {i, hashMap.get(find)};
            }
            else {
                hashMap.put(nums[i], i);
            }
        }

        return null;
    }
}


