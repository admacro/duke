package com.jamesni.interview;import java.util.*;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class BracketsBalanceChecker
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int hasBalancedBrackets(String str)
    {
        // WRITE YOUR CODE HERE
        Map<String, String> brackets = new HashMap<>();
        brackets.put("{", "}");
        brackets.put("[", "]");
        brackets.put("(", ")");
        brackets.put("<", ">");

        Deque<String> leftBrackets = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (brackets.keySet().contains(s)) {
                leftBrackets.push(s);
            } else if (brackets.values().contains(s)) {
                if (s.equals(brackets.get(leftBrackets.peek()))) {
                    leftBrackets.pop();
                }
            }
        }

        return leftBrackets.size() == 0 ? 1 : 0;
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) throws Exception {
        String input1 = "(h[e{lo}!]~)()()()(";
        String input2 = "[](){}<>";
        System.out.println(hasBalancedBrackets(input1));
//        System.out.println(hasBalancedBrackets(input2));
    }
}