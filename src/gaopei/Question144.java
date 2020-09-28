package gaopei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question144 {
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
            result.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
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
        result.add(root.val);
        if (root.left != null) {
            process(root.left, result);
        }
        if (root.right != null) {
            process(root.right, result);
        }
    }

    public static void main(String[] args) {
        Question144 question144 = new Question144();
        TreeNode treeNode = new TreeNode(1);
        System.out.println(question144.preorderTraversal(treeNode));
        treeNode.left = new TreeNode(5);

        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        System.out.println(question144.preorderTraversal1(treeNode));
    }

}
