package com.jamesni.interview;

import java.util.ArrayList;
import java.util.List;

public class CommonManagerFinder {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    // RETURN "null" IF THERE IS NO CLOSEST COMMON MANAGER OR THE GIVEN EMPLOYEES ARE NOT THE PART OF THE COMPANY

    public Employee closestCommonManager(Employee ceo, Employee employee1, Employee employee2) {
        List<Employee> e1Path = new ArrayList<>();
        List<Employee> e2Path = new ArrayList<>();
        findPath(ceo, employee1, e1Path);
        findPath(ceo, employee2, e2Path);

        for (int i = e1Path.size(); i >= 0; i--) {
            Employee eM = e1Path.get(i);
            for (int j = e2Path.size(); j >= 0; j--) {
                Employee eM2 = e1Path.get(i);
                if (eM.equals(eM2)) {
                    return eM;
                }
            }

        }
        return ceo;
    }

    public Employee findPath(Employee root, Employee target, List<Employee> path) {
        if (!root.getReports().contains(target)) {
            for (Employee e : root.getReports()) {
                path.add(findPath(e, target, path));
            }
            return target;
        } else {
            return root;
        }
    }

}