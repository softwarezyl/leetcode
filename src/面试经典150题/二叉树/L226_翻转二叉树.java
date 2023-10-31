package 面试经典150题.二叉树;

import common.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *  示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 *  示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class L226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
