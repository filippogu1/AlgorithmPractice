package AlgorithmPractice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_MoreAdd {

    private Map<Integer, Integer> map;

    public TwoSum_MoreAdd() {
        map = new HashMap<>();
    }

    public void add(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    public boolean find(int targetSum) {
        for (int num : map.keySet()) {
            int target = targetSum - num;
            if (target == num && map.containsKey(target) && map.get(target) > 1) {
                return true;
            }
            if (target != num && map.containsKey(target)) {
                return true;
            }
        }
        return false;
    }
}
