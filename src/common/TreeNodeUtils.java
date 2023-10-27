package common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeUtils {

    public static TreeNode construct(List<Integer> arr) {
        TreeNode root = new TreeNode(arr.get(0));

        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.add(root);

        // 先左后右
        boolean isLeft = true;
        for (int i = 1; i < arr.size(); i++) {
            TreeNode peek = treeNodeDeque.getFirst();

            if (isLeft) {
                if (arr.get(i) != null) {
                    peek.left = new TreeNode(arr.get(i));
                    treeNodeDeque.add(peek.left);
                }
                isLeft = false;
            } else {
                if (arr.get(i) != null) {
                    peek.right = new TreeNode(arr.get(i));
                    treeNodeDeque.add(peek.right);
                }
                treeNodeDeque.removeFirst();
                isLeft = true;
            }
        }
        return root;
    }
}
