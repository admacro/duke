package xyz.admacro.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class demonstrates language changes in Java 7.
 * https://docs.oracle.com/javase/7/docs/technotes/guides/language/enhancements.html
 */
public class Java7 {
    public static void main(String args[]) {
        // The try-with-resources Statement
        // is a try statement that declares one or more resources. A resource is an
        // object that must be closed after the program is finished with it. The try-with-resources
        // statement ensures that each resource is closed at the end of the statement.
        try (BufferedWriter logger = new BufferedWriter(new FileWriter("log.txt"))) {

            // Type Inference for Generic Instance Creation, informally the diamond operator <>
            List<String> statusList = new ArrayList<>(Arrays.asList("OK", "ERROR"));

            // Strings in switch statements
            String status = "OK";
            switch(status) {
            case "OK":
                logger.append("Job done.");
                break;
            case "ERROR":
                logger.append("Job failed.");
                break;
            default:
                logger.append("Job internal error.");
                break;
            }

            // underscore in numeric literals
            int i = 10_000_000;
            Double d = Double.valueOf(3.1415_926);
            float f = 123.456_78f;

            // binary literals with prefix "0b"
            int ib = 0b1010;

            System.out.println(i);
            System.out.println(d);
            System.out.println(f);
            System.out.println(ib);

        } catch (IOException | NullPointerException e) {
            // Catching Multiple Exception Types and Rethrowing Exceptions with Improved Type Checking
            e.printStackTrace();
        }
    }
}
