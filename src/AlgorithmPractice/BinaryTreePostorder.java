package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorder {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        // stack.push(curr);
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (!stack.isEmpty() && stack.peek().val == curr.val) {
                curr = curr.right;
            } else {
                res.add(curr.val);
                curr = null;
            }
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

        BinaryTreePostorder BPost = new BinaryTreePostorder();
        List<Integer> res = BPost.postorderTraversal(root);

        System.out.println(Arrays.toString(res.toArray()));
    }

}
