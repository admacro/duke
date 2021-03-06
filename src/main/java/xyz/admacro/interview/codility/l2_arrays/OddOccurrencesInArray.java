package xyz.admacro.interview.codility.l2_arrays;


import java.util.HashSet;
import java.util.Set;

class OddOccurrencesInArray {

    public int solution(int[] a) {
        Set<Integer> s = new HashSet<>();
        for (int i : a) {
            if (!s.contains(i)) {
                s.add(i);
            } else {
                s.remove(i);
            }
        }
        if (s.size() == 1) {
            return s.iterator().next();
        }

        return 0;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray s = new OddOccurrencesInArray();
        System.out.print(s.solution(new int[]{1, 2, 1, 4, 2, 4, 7, 7, 9, 1, 2, 1, 4, 2, 4, 7, 7, 9, 1, 2, 1, 4, 2, 4, 7, 7, 9, 1, 2, 1, 4, 2, 4, 7, 7, 9, 8}));
    }

}