package AlgorithmPractice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] dataParts = data.split(",");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(dataParts));
        return  buildTree(q);
    }

    public TreeNode buildTree(Queue<String> q) {
        String nodeStr = q.poll();
        if (nodeStr.equals("null")) return null;
        TreeNode currRoot = new TreeNode(Integer.parseInt(nodeStr));
        currRoot.left = buildTree(q);
        currRoot.right = buildTree(q);
        return currRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);

        BinaryTreeSerialization bts = new BinaryTreeSerialization();
        String str = bts.serialize(root);
        System.out.println(str);

    }
}
