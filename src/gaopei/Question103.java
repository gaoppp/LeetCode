package gaopei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 *  
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean desc = false;
        while (!stack.isEmpty()) {
            int len = stack.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
                if (desc) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
            }
            desc = !desc;
            result.add(list);
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);

        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);


        Question103 question = new Question103();
        System.out.println(question.zigzagLevelOrder(node));

    }
}
