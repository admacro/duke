package xyz.admacro.interview.codility;

import java.util.Arrays;

class ArrayRotation {

    public int[] solution(int[] a, int times) {
        int len = a.length;
        if (len > 0) {
            if (times > len) {
                times = times % len;
            }
            int[] b = new int[a.length];
            System.arraycopy(a, len - times, b, 0, times);
            System.arraycopy(a, 0, b, times, len - times);
            return b;
        }
        return a;
    }

    public static void main(String[] args) {
        ArrayRotation s = new ArrayRotation();
        for (int i: s.solution(new int[]{1,2,3,4,5,6,7,8,9,10}, 4)) {
            System.out.print(i + " ");
        }
    }

}