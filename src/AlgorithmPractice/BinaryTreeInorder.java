package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        // stack.push(curr);
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    // The thread is not built yet. Connect to curr.
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    // The thread is already built. Break it!
                    temp.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            } else {
                res.add(curr.val);
                curr = curr.right;
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

        BinaryTreeInorder BIn = new BinaryTreeInorder();
        List<Integer> res1 = BIn.inorderTraversal(root);
        List<Integer> res2 = BIn.morrisTraversal(root);

        System.out.println(Arrays.toString(res1.toArray()));
        System.out.println(Arrays.toString(res2.toArray()));
    }
}
