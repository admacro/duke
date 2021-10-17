package xyz.admacro.interview.nomura;

/**
 * Given an array [0,1,0,1,1] representing the results of a series of coin flipping.
 * 0 means tail, and 1 means head. Calculate the minimum number of steps to make the
 * results into an alternating pattern [0,1,0,1,0].
 *
 * Examples:
 * [0,1,1,0] => 2 steps (either the first two: [1*,0*,1,0], or the last two: [0,1,0*,1*])
 * [1,1,0,1,1,0] => 3 steps ([0*,1,0,1,0*,1*])
 */
public class CoinFlip {
    public int solution(int[] A) {
        int reverseCount = 0;
        return reverseCount;
    }

    public static void main(String[] args) {
        int[] a = {1,0,1,0,1,1};
        CoinFlip s = new CoinFlip();
        s.solution(new int[]{1,0,1,0,1,1}); // 1
        s.solution(new int[]{1,1,0,1,1}); // 2
        s.solution(new int[]{0,1,0}); // 0
        s.solution(new int[]{0,1,1,0}); // 2

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
