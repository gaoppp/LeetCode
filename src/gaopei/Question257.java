package gaopei;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question257 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs(root, result, null);
        return result;
    }

    private void dfs(TreeNode node, List<String> list, String path) {
        if (path == null) {
            path = String.valueOf(node.val);
        } else {
            path = path + "->" + node.val;
        }
        if (node.left == null && node.right == null) {
            list.add(path);
            return;
        }
        if (node.left != null) {
            dfs(node.left, list, path);
        }
        if (node.right != null) {
            dfs(node.right, list, path);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        Question257 question = new Question257();
        System.out.println(question.binaryTreePaths(treeNode));

        treeNode.left = new TreeNode(2);
        System.out.println(question.binaryTreePaths(treeNode));

        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);

        System.out.println(question.binaryTreePaths(treeNode));


    }
}
