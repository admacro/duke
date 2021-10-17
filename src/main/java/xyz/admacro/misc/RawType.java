package xyz.admacro.misc;

public class RawType {
    public static void main(String args[]) {
        Gen<Integer> iOb = new Gen<Integer>(88);
        Gen<String> strOb = new Gen<String>("Generics Test");

        Gen raw = new Gen(Double.valueOf(3.14d));

        // Cast is necessary because type is unknown.
        double d = (Double) raw.getob();
        System.out.println("value: " + d);

        strOb = raw; // assignment is OK, but will cause potential exceptions
        String str = strOb.getob(); // exception

        // This assignment also overrides type safety.
        raw = iOb; // assignment is OK, but will cause potential exceptions
        d = (Double) raw.getob(); // exception

    }
}

class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getob() {
        return ob;
    }
}

