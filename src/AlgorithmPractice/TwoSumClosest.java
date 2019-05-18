package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Choose one element from arr1 and arr2 each, and find the pair which is the closest to target
public class TwoSumClosest {

    public List<int[]> getClosestTwoSum(int[] arr1, int[] arr2, int target) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        List<int[]> res = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;
        int left = 0, right = arr2.length - 1;

        // 1. 1st loop to find out minDiff that does not exceeds target
        while (left < arr1.length && right >= 0) {
            if (arr1[left] + arr2[right] > target) {
                right--;
            } else if (arr1[left] + arr2[right] < target) {
                minDiff = Math.min(minDiff, target - arr1[left] - arr2[right]);
                left++;
            } else {
                minDiff = 0;
                break;
            }
        }

        // 2. 2nd loop to get the combinations to return res
        // Reason why we do 2nd loop here, is because minDiff could have multiple pairs of answers.
        left = 0;
        right = arr2.length - 1;
        while (left < arr1.length && right >= 0) {
            if (arr1[left] + arr2[right] + minDiff > target) {
                right--;
            } else if (arr1[left] + arr2[right] + minDiff < target) {
                left++;
            } else {
                res.add(new int[]{arr1[left], arr2[right]});
                left++;
                right--;
            }
        }

        for (int[] set : res) {
            System.out.println(Arrays.toString(set));
        }

        return res;
    }

    public static void main(String[] args) {
        TwoSumClosest test = new TwoSumClosest();

        test.getClosestTwoSum(new int[]{1,2,3}, new int[]{4,5,6},7);
        test.getClosestTwoSum(new int[]{4,5,6}, new int[]{1,2,3},7);
        test.getClosestTwoSum(new int[]{100,20,30}, new int[]{40,50,60},99);
//        test.getClosestTwoSum({}, {}, );
//        test.getClosestTwoSum({}, {}, );
    }
}
