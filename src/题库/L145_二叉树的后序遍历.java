package 题库;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L145_二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        this.postOrder(root, valList);

        return valList;
    }

    private void postOrder(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        this.postOrder(root.left, valList);
        this.postOrder(root.right, valList);
        valList.add(root.val);
    }
}
