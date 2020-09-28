package gaopei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question94 {
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
        while (!stack.isEmpty() || root!=null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
               root = treeNode.right;
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
        result.add(root.val);
        if (root.right != null) {
            process(root.right, result);
        }
    }

    public static void main(String[] args) {
        Question94 question94 = new Question94();
        TreeNode treeNode = new TreeNode(1);
        System.out.println(question94.preorderTraversal(treeNode));
        treeNode.left = new TreeNode(5);

        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        System.out.println(question94.preorderTraversal(treeNode));
    }

}
