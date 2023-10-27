package 题库;

import common.TreeNode;
import common.TreeNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L144_二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> valList = new LinkedList<>();
        prePrint(root, valList);

        System.out.println(valList.toString());
        return valList;
    }

    public void prePrint(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        valList.add(root.val);
        prePrint(root.left, valList);
        prePrint(root.right, valList);
    }

    public static void main(String[] args) {
        L144_二叉树的前序遍历 test = new L144_二叉树的前序遍历();

        TreeNode root = TreeNodeUtils.construct(Arrays.asList(1, null, 2, 3));
        test.preorderTraversal(root);
    }
}
