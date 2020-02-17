import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/03 15:01
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class DeOrSerializeBinaryTree {



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return root.val + "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                sb.append(",null");
            } else {
                sb.append("," + temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }

        String res = sb.substring(1);
        String[] arr = res.split(",");
        int index = arr.length - 1;
        while (index >= 0) {
            if (!"null".equals(arr[index])) {
                break;
            }
            index--;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(root.val);
        for (int i = 1; i <= index; i++) {
            sb2.append("," + arr[i]);
        }
        return sb2.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.length() == 0) {
            return null;
        }
        if (-1 == data.indexOf(',')) {
            return new TreeNode(Integer.parseInt(data));
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        if (arr.length < 3) {
            root.left = new TreeNode(Integer.parseInt(arr[1]));
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 1;
        queue.add(root);
        while (queue.size() != 0) {
            if (index > arr.length - 1) {
                break;
            }
            TreeNode node = queue.poll();
            if (node != null) {
                node.left = "null".equals(arr[index]) ? null : new TreeNode(Integer.parseInt(arr[index]));
                queue.add(node.left);
                index++;

                node.right = index > arr.length - 1 ? null : (
                        "null".equals(arr[index]) ? null : new TreeNode(Integer.parseInt(arr[index])));

                queue.add(node.right);
                index++;
            }

        }
        return root;
    }
}
