package xyz.admacro.interview.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 6
 * A[3] = 4
 * A[4] = 1
 * A[5] = 2
 * the function should return 5.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class MissingInteger {

    public int solution(int[] a) {
        int num = 1;
        HashSet<Integer> hset = new HashSet<Integer>();

        for (int i = 0 ; i < a.length; i++) {
            hset.add(a[i]);

            while (hset.contains(num)) {
                num++;
            }
        }

        return num;
//        Arrays.sort(a);
//        Set<Integer> posInt = new HashSet<>();
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] > 0) {
//                posInt.add(a[i]);
//            }
//        }
//        Integer[] sa = new Integer[posInt.size()];
//        sa = posInt.toArray(sa);
//
//        if (sa.length == 0) return 1;
//        if (sa.length == 1) {
//            return sa[0] == 1 ? 2 : 1;
//        } else {
//            if (sa[0] > 1) {
//                return 1;
//            } else {
//                for (int i = 1; i < sa.length; i++) {
//                    if (sa[i] - sa[i - 1] > 1) {
//                        return sa[i - 1] + 1;
//                    }
//                }
//            }
//        }
//        return 1;
    }


    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(new int[]{-100})); // 1
        System.out.println(missingInteger.solution(new int[]{1})); // 2
        System.out.println(missingInteger.solution(new int[]{3})); // 1
        System.out.println(missingInteger.solution(new int[]{1,3,5,7,9})); // 2
        System.out.println(missingInteger.solution(new int[]{1,2,3,4,7,9})); // 5
        System.out.println(missingInteger.solution(new int[]{2,4,7,9})); // 1
        System.out.println(missingInteger.solution(new int[]{-2,-4,-7,-9})); // 1
        System.out.println(missingInteger.solution(new int[]{1, 3, 6, 4, 1, 2})); // 5
        System.out.println(missingInteger.solution(new int[]{-1, 3, 6, -1004, -100001, 2000000,34234,34,3,5,435,34,5,3,5342})); // 1
        System.out.println(missingInteger.solution(new int[]{ 00001, 2000000,34234,5342})); // 1
    }
}
