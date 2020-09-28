package gaopei;

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
public class Question114 {

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

    public void flatten(TreeNode root) {
        pre(root);
    }

    public TreeNode pre(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        TreeNode last = root;
        if (left != null) {
            last = pre(left);
            root.right = left;
            root.left = null;
        }

        if (right != null) {
            TreeNode newLast = pre(right);
            last.right = right;
            last = newLast;
        }
        return last;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(6);

        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left = new TreeNode(3);

        Question114 question = new Question114();
        question.flatten(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }

        node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        question.flatten(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }

        node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        question.flatten(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }
}
