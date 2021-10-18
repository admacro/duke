package xyz.admacro.misc;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * This class demonstrates lambda expressions in Java 8.
 */
public class Java8LambdaExpressions {
    public static void main(String args[]) {
        // classic
        List<Integer> list = List.of(1,4,9);
        list.forEach(e -> System.out.println(Math.sqrt(e)));

        // typed
        List<String> names = List.of("James", "Russell");
        names.forEach((String s) -> System.out.println(s));

        // multiline
        Map<Integer, String> map = Map.of(1,"James",2,"Russell");
        map.forEach((Integer k, String v) -> { // types can be ommitted, aka. (k, v)
                System.out.println(k + " => " + v);
            });

        // with closure
        String greeting = "Hello";
        names.forEach(e -> System.out.println(greeting + " " + e));

        // Consumer
        String hi = "hi"; // notice here no final is required (it was, before Java 8)
        names.forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println(hi + " " + s);
                }
            });
    }
}
