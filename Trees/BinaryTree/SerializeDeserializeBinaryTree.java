package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/">SerializeDeserializeBinaryTree</a>
 */
public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return null;
        }
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("N ");
            } else {
                sb.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] str = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode parent = q.poll();
            if (!str[i].equals("N")) {
                TreeNode node = new TreeNode(Integer.parseInt(str[i]));
                q.add(node);
                parent.left = node;
            }
            if (!str[++i].equals("N")) {
                TreeNode node = new TreeNode(Integer.parseInt(str[i]));
                q.add(node);
                parent.right = node;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));