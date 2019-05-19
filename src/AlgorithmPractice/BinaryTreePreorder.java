package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

//     4
//   /   \
//  2     6
// / \   /
//1   3 5


public class BinaryTreePreorder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);

        BinaryTreePreorder BPre = new BinaryTreePreorder();
        List<Integer> res = BPre.preorderTraversal(root);

        System.out.println(Arrays.toString(res.toArray()));
    }

}
