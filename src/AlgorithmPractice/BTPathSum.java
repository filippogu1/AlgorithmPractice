package AlgorithmPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BTPathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Path Sum I - Find if any path starting from root to leaf, add up to sum
    // Passed in LC.
    public boolean hasPathSumI(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;

        return hasPathSumI(root.left, sum - root.val) || hasPathSumI(root.right, sum - root.val);
    }

    // Path Sum II - Find all root-to-leaf paths that add up to sum
    // Passed in LC
    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs1(root, sum, new ArrayList<>(), res);
        return res;
    }

    public void dfs1(TreeNode root, int target, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;

        path.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            dfs1(root.left, target - root.val, path, res);
            dfs1(root.right, target - root.val, path, res);
        }

        path.remove(path.size() - 1);
    }

    // Path Sum III - Find the number of paths that sum to a given value.
    // Passed in LC
    public int pathSumIII(TreeNode root, int sum) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        return dfs2(root, 0, sum, preSumMap);
    }

    public int dfs2(TreeNode root, int currSum, int target, Map<Integer, Integer> preSumMap) {
        if (root == null) return 0;

        int resCnt = 0;
        currSum += root.val;
        resCnt += preSumMap.getOrDefault(currSum - target, 0);

        preSumMap.put(currSum, preSumMap.getOrDefault(currSum, 0) + 1);
        resCnt += dfs2(root.left, currSum, target, preSumMap)
                + dfs2(root.right, currSum, target, preSumMap);
        preSumMap.put(currSum, preSumMap.get(currSum) - 1);

        return resCnt;
    }
}
