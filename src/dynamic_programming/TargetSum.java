package dynamic_programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TargetSum {
    public static boolean canSum(int[] array, int target, Boolean[] memo) {
        if (target == 0) {
            return true;
        }
        if (memo[target] != null) {
            return memo[target];
        }
        boolean res = false;
        for (int n : array) {
            if (target - n >= 0) {
                res = canSum(array, target - n, memo);
                if (res) {
                    break;
                }
            }
        }
        memo[target] = res;
        return memo[target];
    }

    public static List<Integer> howSum(int[] array, int target) {
        if (target == 0 ) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        for (int n : array) {
            List<Integer>  result = howSum(array, target - n);
            if (result != null) {
                result.add(n);
                return result;
            }
        }
        return null;
    };


    public static List<Integer> bestSum(int[] array, int target) {
        if (target == 0) {
            return new LinkedList<>();
        }
        if (target < 0) {
            return null;
        }
        List<Integer> shortestCombination = null;
        for (int n : array) {
            int remainder = target - n;
            List<Integer> reminderList = bestSum(array, remainder);
            if (reminderList != null) {
                reminderList.add(n);
                if (shortestCombination == null || reminderList.size() < shortestCombination.size()) {
                    shortestCombination = reminderList;
                }
            }
        }
        return shortestCombination;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,3,4};
        int sum = 7;
        System.out.println(canSum(arr, sum, new Boolean[sum + 1]));
        System.out.println(howSum(arr, sum));
        System.out.println(bestSum(arr, sum));

    }
}
