package com.jamesni.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BracketsBalanceChecker {

    /**
     * @param str content to check
     * @return 1 if balanced; 0 if not balanced
     */
    public static int hasBalancedBrackets(String str) {
        String bracketsStr = "{}[]()<>";
        Map<String, String> brackets = new HashMap<>();
        brackets.put("{", "}");
        brackets.put("[", "]");
        brackets.put("(", ")");
        brackets.put("<", ">");

        Deque<String> leftBrackets = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            if (bracketsStr.indexOf(str.charAt(i)) > -1) {
                String s = String.valueOf(str.charAt(i));
                if (brackets.keySet().contains(s)) {
                    leftBrackets.push(s);
                } else if (brackets.values().contains(s)) {
                    if (s.equals(brackets.get(leftBrackets.peek()))) {
                        leftBrackets.pop();
                    }
                }
            }
        }

        return leftBrackets.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        String input1 = "sdf(sfdh[esdf{lodf}!asfdsdf]~())(w))(sfda)()(";
        String input2 = "[];;asf()sdfs{9(}<>";
        String input3 = "[](){df}<(;dfs;<>)>ss";
        System.out.println(hasBalancedBrackets(input1));
        System.out.println(hasBalancedBrackets(input2));
        System.out.println(hasBalancedBrackets(input3));
    }
}