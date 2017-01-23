package xyz.admacro.interview.codility;

/**
 * A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a zero-indexed array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class PermMissingElem {

    public int solution(int[] a) {
        int n = a.length;
        int r = 0;
        for (int i = 0; i < n; i++) {
            r += a[i] - i;
        }
        System.out.println(r);
        for (int i = n; i <= 2*n; i++) {
            if (r == i) {
                return 2 * n - i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        System.out.println(permMissingElem.solution(new int[]{1,2,4,5,3,6,8,7,10}));
    }
}
