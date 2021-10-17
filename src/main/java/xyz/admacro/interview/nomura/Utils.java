package xyz.admacro.interview.nomura;

public interface Utils {
    static void test() {
        System.out.println("This is a static method in an abstract class");
    }

    static void main(String[] args) {
        Utils.test();
        System.out.println("Test");
    }
}
