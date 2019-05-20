package AlgorithmPractice;

public class BTResultType_LC865 {

    class ResultType {
        TreeNode node;
        int maxDist;
        ResultType(TreeNode node, int maxDist) {
            this.node = node;
            this.maxDist = maxDist;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    public ResultType dfs(TreeNode root) {
        if (root == null) return new ResultType(null, 0);
        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);
        if (left.maxDist > right.maxDist) {
            return new ResultType(left.node, left.maxDist + 1);
        } else if (left.maxDist < right.maxDist) {
            return new ResultType(right.node, right.maxDist + 1);
        } else {
            return new ResultType(root, left.maxDist + 1);
        }
    }
}
