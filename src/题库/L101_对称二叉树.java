package 题库;

import common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 *  示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class L101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTree(root, root);
    }

    private boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }
}
