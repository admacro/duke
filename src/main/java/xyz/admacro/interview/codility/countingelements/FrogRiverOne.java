package xyz.admacro.interview.codility.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * A small frog wants to get to the other side of a river. The frog is initially located on
 * one bank of the river (position 0) and wants to get to the opposite bank (position X+1).
 * Leaves fall from a tree onto the surface of the river.
 * <p>
 * You are given a zero-indexed array A consisting of N integers representing the falling leaves.
 * A[K] represents the position where one leaf falls at time K, measured in seconds.
 * <p>
 * The goal is to find the earliest time when the frog can jump to the other side of the river.
 * The frog can cross only when leaves appear at every position across the river from 1 to X (that is,
 * we want to find the earliest moment when all the positions from 1 to X are covered by leaves).
 * You may assume that the speed of the current in the river is negligibly small, i.e. the leaves
 * do not change their positions once they fall in the river.
 * <p>
 * For example, you are given integer X = 5 and array A such that:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear
 * in every position across the river.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int X, int[] A); }
 * <p>
 * that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns
 * the earliest time when the frog can jump to the other side of the river.
 * <p>
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 * <p>
 * For example, given X = 5 and array A such that:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * the function should return 6, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(X), beyond input storage (not counting the storage
 * required for input arguments).
 * Elements of input arrays can be modified.
 */
public class FrogRiverOne {
    public int solution(int X, int[] A) {
        Set<Integer> steps = new HashSet<>(X);
        for (int i = 1; i <= X; i++) {
            steps.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if (steps.contains(A[i])) {
                steps.remove(A[i]);
            }
            if (steps.size() == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        System.out.println(frogRiverOne.solution(3, new int[]{1, 3, 1, 3, 2, 1, 3}));
    }
}
