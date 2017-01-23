package xyz.admacro.interview.nomura.task1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

class Solution {
    public int solution(Tree T) {
        Stack<Integer> numbers = new Stack<>();
        int vCount = traverse(T, numbers);
        return vCount;
    }

    public int traverse(Tree root, Stack<Integer> numbers) {
        int vCount = 0;
        if (root != null) {
            numbers.push(root.x);
            if (isVisible(root.x, numbers)) {
                vCount += 1;
            }
        }
        if (root.l != null) {
            vCount += traverse (root.l, numbers);
        }
        if (root.r != null) {
            vCount += traverse (root.r, numbers);
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
        Solution s = new Solution();
        Tree tree0 = new Tree(20, null, null);
        Tree tree1 = new Tree(21, null, null);
        Tree tree2 = new Tree(1, null, null);
        Tree tree3 = new Tree(3, tree0, tree1);
        Tree tree4 = new Tree(10, tree2, null);
        Tree tree5 = new Tree(5, tree3, tree4);

        System.out.println(s.solution(tree5));
    }

    static class Tree {
        public Tree(int x, Tree l, Tree r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }

        public int x;
        public Tree l;
        public Tree r;
    }
}