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
public class Question100 {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null || q == null) || q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(5);

        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left = new TreeNode(3);

        TreeNode node1 = new TreeNode(1);
        node1.right = new TreeNode(5);
        node1.right.right = new TreeNode(6);

        node1.left = new TreeNode(2);
        node1.left.right = new TreeNode(4);
        node1.left.left = new TreeNode(3);

        Question100 question = new Question100();
        System.out.println(question.isSameTree(node,node1));

    }
}
