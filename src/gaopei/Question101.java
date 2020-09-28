package gaopei;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question101 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root.right);
        q.offer(root.left);
        while (!q.isEmpty()) {
            TreeNode one = q.poll();
            TreeNode two = q.poll();
            if (one == null && two == null) {
                continue;
            }
            if (one == null || two == null || one.val != two.val) {
                return false;
            }
            q.offer(one.right);
            q.offer(two.left);
            q.offer(one.left);
            q.offer(two.right);

        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.right, root.left);
    }

    public boolean isSymmetric(TreeNode right, TreeNode left) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(right.left, left.right) && isSymmetric(right.right, left.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        Question101 question = new Question101();
        System.out.println(question.isSymmetric(root));
    }
}
