package xyz.admacro.interview.nomura.task2;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int n) {
        // write your code in Java SE 8
        System.out.println(n&1);
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(15));
    }

}