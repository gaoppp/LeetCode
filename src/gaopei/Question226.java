package gaopei;

public class Question226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;

        root.left = right;
        root.right = left;

        if (right != null) {
            invertTree(right);
        }
        if (left != null) {
            invertTree(left);
        }
        return root;
    }

}
