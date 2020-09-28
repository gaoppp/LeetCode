package gaopei.offer;

import gaopei.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return process(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1, indexMap);
    }

    public TreeNode process(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int inIndex = indexMap.get(preorder[preStart]);

        int leftLen = inIndex - inStart;
        int rightLen = inEnd - inIndex;

        root.left = process(preorder, inorder, preStart + 1, preStart + leftLen, inStart, inStart + leftLen, indexMap);
        root.right = process(preorder, inorder, preStart + leftLen + 1, preEnd, inIndex + 1, inEnd, indexMap);
        return root;


//            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
//            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
//            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
//            root.left = leftSubtree;
//            root.right = rightSubtree;
//            return root;
      //  }


    }

    public static void main(String[] args) {
        Question07 question07 = new Question07();
        TreeNode treeNode = question07.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        System.out.println(treeNode.val);
        System.out.println(treeNode.right);
        System.out.println(treeNode.left);

    }
}
