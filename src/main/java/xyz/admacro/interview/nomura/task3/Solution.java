package xyz.admacro.interview.nomura.task3;

class Solution {
    public int solution(String S) {
        if (S.length() > 0) {
            int number = Integer.parseInt(S, 2);
            int i = 0;
            while (number > 0) {
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number -= 1;
                }
                i++;
            }
            return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("")); // 0
        System.out.println(s.solution("011100")); // 28 7
        System.out.println(s.solution("100011")); // 35 8
        System.out.println(s.solution("11010101")); // 213 12
        System.out.println(s.solution("11010101010100101001010001")); // 55921233 37
    }

}