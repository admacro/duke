package xyz.admacro.interview.nomura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    static void findSubsets(List<Integer> list, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = i; j < list.size(); j++) {
                subset.add(list.get(j));
                if (sum(subset) == targetSum) {
                    results.add(new ArrayList<>(subset));
                }
            }
            subset.clear();
        }

        if (results.size() == 0) {
            System.out.println("给定集合" + list + "不存在子集和为" + targetSum + "的集合。");
        } else {
            System.out.println("给定集合" + list + "，存在子集和为" + targetSum + "的集合，它们是：" + results + "。");
        }
    }

    static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        findSubsets(Arrays.asList(2, 0, 3, -2, 7), 0);
        findSubsets(Arrays.asList(-7, -3, 5, 8, -2), 0);
        findSubsets(Arrays.asList(1, 2, 3, 4, 5, 6), 8);
    }
}
