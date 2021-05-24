package xyz.admacro.interview.nomura.task1;

import java.util.Iterator;
import java.util.Stack;

/**
 * Depth first search
 *
 * Visible node problem:
 * In a binary tree, node N is considered "visible" if N's value
 * is the greatest on the path from root to N. Root node is always
 * visible.
 *
 * Example:
 * In the following tree, 7 is visible: 5-7; 9 is visible: 5-7-9; 5 is visible.
 *     5
 *    / \
 *   7   4
 *  /\   /\
 * 3 9  2 1
 */
class VisibleTreeNode {
    public int solution(TreeNode T) {
        Stack<Integer> numbers = new Stack<>();
        int vCount = traverse(T, numbers);
        return vCount;
    }

    public int traverse(TreeNode root, Stack<Integer> numbers) {
        int vCount = 0;
        if (root != null) {
            numbers.push(root.value);
            if (isVisible(root.value, numbers)) {
                vCount += 1;
            }
        }
        if (root.left != null) {
            vCount += traverse(root.left, numbers);
        }
        if (root.right != null) {
            vCount += traverse(root.right, numbers);
        }
        numbers.pop();
        return vCount;

    }

    public boolean isVisible(int x, Stack<Integer> numbers) {
        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext()) {
            if (x < iter.next()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        VisibleTreeNode s = new VisibleTreeNode();
        TreeNode treeNode0 = new TreeNode(20, null, null);
        TreeNode treeNode1 = new TreeNode(21, null, null);
        TreeNode treeNode2 = new TreeNode(1, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode0, treeNode1);
        TreeNode treeNode4 = new TreeNode(10, treeNode2, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode3, treeNode4);

        System.out.println(s.solution(treeNode5));
    }

    static class TreeNode {
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int value;
        public TreeNode left;
        public TreeNode right;
    }
}