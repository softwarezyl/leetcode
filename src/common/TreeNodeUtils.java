package common;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNodeUtils {

    public static TreeNode construct(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);

        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.add(root);

        for (int i = 1; i < arr.length; i += 2) {
            TreeNode peek = treeNodeDeque.getFirst();

            peek.left = new TreeNode(arr[i]);
            treeNodeDeque.offer(peek.left);

            peek.right = new TreeNode(arr[i + 1]);
            treeNodeDeque.offer(peek.right);

            treeNodeDeque.pollFirst();
        }
        return root;
    }
}
