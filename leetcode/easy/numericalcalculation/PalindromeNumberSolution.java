package leetcode.easy.numericalcalculation;

/**
 * Given an integer x, return true if x is palindrome(회문) integer.
 *
 * An integer is a palindrome when it reads the same backward as(같이, ~로서) forward.
 *
 * For example, 121 is a palindrome while(~인 데 반하여) 123 is not.
 */

public class PalindromeNumberSolution {
    public static void main(String[] args) {
        PalindromeNumberSolution solution = new PalindromeNumberSolution();
        System.out.println(solution.isPalindrome(121));
    }

    private boolean isPalindrome(int x) {
        if(x < 0) return false;

        long reverseNumber = 0;
        int target = x;
        while(target != 0) {
            reverseNumber = (reverseNumber * 10) + (target % 10);
            target = target / 10;
        }

        return reverseNumber == x;
    }
}
