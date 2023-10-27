package 题库;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class L94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> valList = new LinkedList<>();
        this.inOrder(root, valList);

        return valList;
    }

    private void inOrder(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        this.inOrder(root.left, valList);
        valList.add(root.val);
        this.inOrder(root.right, valList);
    }
}
