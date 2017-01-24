package xyz.admacro.interview.codility.l4_countingelements;

import java.util.Arrays;

/**
 * Created by jni17 on 1/23/17.
 */
public class PermCheck {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();
        System.out.println(permCheck.solution(new int[]{1, 3, 2}));
        System.out.println(permCheck.solution(new int[]{4, 1, 3, 2}));
        System.out.println(permCheck.solution(new int[]{4, 1, 3, 2, 5, 7, 6}));
        System.out.println(permCheck.solution(new int[]{4, 1, 3, 2, 5, 7, 6, 9}));
    }
}
