package gaopei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question145 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            result.add(0, treeNode.val);
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        process(root, result);
        return result;
    }

    public void process(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            process(root.left, result);
        }
        if (root.right != null) {
            process(root.right, result);
        }
        result.add(root.val);
    }

    public static void main(String[] args) {
        Question145 question145 = new Question145();
        TreeNode treeNode = new TreeNode(1);
        System.out.println(question145.preorderTraversal(treeNode));
        treeNode.left = new TreeNode(5);

        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        System.out.println(question145.preorderTraversal(treeNode));
    }

}
