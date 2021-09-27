package xyz.admacro.misc;

/**
 * This class demonstrates interface default methods in Java 8.
 */
public class Java8DefaultMethods {
    interface DefaultMethodInterface {
        default void foo() {
            System.out.println("Default method");
        }
    }

    // ignoring the default mothed makes interface A inherit the default method
    interface A extends DefaultMethodInterface {}

    interface B extends DefaultMethodInterface {
        // redeclare the default method makes it an abstract method
        // this throws away the implmentation of the default method
        public void foo();
    }

    interface C extends DefaultMethodInterface {
        // redefining the default method overrides the default method
        default void foo() {
            System.out.println("default method is overrided in interface C");
            DefaultMethodInterface.super.foo();
        };
    }

    static class ImplA implements A {
        public void test() {
            foo();
        }
    }

    static class ImplB implements B {
        // must overrides abstract method in interface B
        public void foo() {
            System.out.println("this overrides the abstract method in B");
        }

        public void test() {
            foo(); // this calls B#foo()
        }
    }

    
    static class ImplC implements C {
        public void test() {
            foo();
        }
    }

    public static void main(String args[]) {
        ImplA a = new ImplA();
        a.foo();
        ImplB b = new ImplB();
        b.foo();
        ImplC c = new ImplC();
        c.foo();
    }
}
