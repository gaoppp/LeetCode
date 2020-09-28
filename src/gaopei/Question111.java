package gaopei;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question111 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        int depth = 1;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    linkedList.offer(node.left);
                }
                if (node.right != null) {
                    linkedList.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(Integer.MIN_VALUE);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(7);

        node.right = new TreeNode(3);
       node.right.right = new TreeNode(7);
//        node.right.left = new TreeNode(15);


        Question111 question = new Question111();
        System.out.println(question.minDepth(node));

    }
}
