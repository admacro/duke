package xyz.admacro.interview.codility.iterations;

class BinaryGap {

    public int solution(int n) {
        String binary = Integer.toBinaryString(n).replaceAll("0*$", "");
        String[] gaps = binary.split("1");
        int max = 0;
        for (int i = 0; i < gaps.length; i++) {
            max = Math.max(gaps[i].length(), max);
        }

        return max;
    }

    public static void main(String[] args) {
        BinaryGap s = new BinaryGap();
        System.out.println(s.solution(561892));
        System.out.println(s.solution(1041));
        System.out.println(s.solution(15));
    }

}