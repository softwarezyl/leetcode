package 面试经典150题.二叉树;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L105_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        int pIdx = map.get(rootVal);

        root.left = buildTree(preorder, preLeft + 1, pIdx - inLeft + preLeft, map, inLeft, pIdx - 1);
        root.right = buildTree(preorder, pIdx - inLeft + preLeft + 1, preRight, map, pIdx + 1, inRight);
        return root;
    }
}
