package xyz.admacro.alittlejava.ch1;

public class Salt extends Seasoning {
    private int x;
    public static void main(String[] args) {
        System.out.println(new Salt());;
    }

    @Override
    public String toString() {
        return "Salt{" +
                "x=" + x +
                '}';
    }
}
