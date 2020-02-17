import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            int value = 0;
            while(size > 0){
                TreeNode node = queue.poll();
                value = node.val;
                queue.add(node.left);
                queue.add(node.right);
                size--;
            }
            res.add(value);
        }
        return res;
    }
}