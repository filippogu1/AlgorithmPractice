package AlgorithmPractice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TwoSum_MoreFind {

    private Set<Integer> numSet;
    private Set<Integer> sumSet;

    public TwoSum_MoreFind() {
        numSet = new HashSet<>();
        sumSet = new HashSet<>();
    }

    public void add(int val) {
        if (numSet.contains(val)) {
            sumSet.add(val * 2);
        } else {
            Iterator<Integer> iter = numSet.iterator();
            while (iter.hasNext()) {
                sumSet.add(iter.next() + val);
            }
            numSet.add(val);
        }
    }

    public boolean find(int targetSum) {
        return sumSet.contains(targetSum);
    }
}
