package AlgorithmPractice;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithTargetSum {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int count = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (preSumMap.containsKey(sum - S)) {
                count += preSumMap.get(sum - S);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarrayWithTargetSum s = new SubarrayWithTargetSum();
        int[] arr = new int[]{1, 2, 3, 2, 3, 1, 1};
        int target = 5;
        System.out.println(s.numSubarraysWithSum(arr, target));
    }
}
