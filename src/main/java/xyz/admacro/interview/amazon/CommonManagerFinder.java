package xyz.admacro.interview.amazon;

import java.util.ArrayList;
import java.util.List;

public class CommonManagerFinder {

    public static void main(String[] args) {
        Employee cto = new Employee(1, "David");
        Employee cio = new Employee(2, "Dragon");
        Employee cfo = new Employee(3, "Steve");
        Employee mike = new Employee(4, "Mike");
        Employee jack = new Employee(5, "Jack");
        Employee james = new Employee(6, "James");
        Employee robin = new Employee(7, "Robin");
        Employee cathy = new Employee(8, "Cathy");
        Employee helen = new Employee(9, "Helen");
        Employee john = new Employee(10, "John");
        Employee commonManager = closestCommonManager(getCEO(), cto, james);
        System.out.println(commonManager.getName());
    }


    /**
     * The idea is first to get the path of the two employees, then find out the first common employee of the paths.
     *
     * @param ceo
     * @param employee1
     * @param employee2
     * @return the common manager if found, null if not found
     */
    public static Employee closestCommonManager(Employee ceo, Employee employee1, Employee employee2) {
        List<Employee> e1Path = new ArrayList<>();
        List<Employee> e2Path = new ArrayList<>();

        // Find the paths of the two employees
        findPath(ceo, employee1, e1Path);
        findPath(ceo, employee2, e2Path);

        // Add root node (CEO here) at the end of the list
        e1Path.add(ceo);
        e2Path.add(ceo);

        System.out.println(e1Path);
        System.out.println(e2Path);

        for (int i = 0; i < e1Path.size(); i++) {
            Employee e1 = e1Path.get(i);
            for (int j = 0; j < e2Path.size(); j++) {
                Employee e2 = e2Path.get(j);
                if (e1.getId() == e2.getId()) {
                    return e1;
                }
            }

        }
        return null;
    }

    /**
     * This finds the path from CEO to the target employee
     *
     * @param parent root node to start the traverse from
     * @param target the employee to locate
     * @param path   A list to hold the employees while traveling through the nodes
     * @return
     */
    public static boolean findPath(Employee parent, Employee target, List<Employee> path) {
        if (parent.getId() != target.getId()) {
            for (Employee e : parent.getReports()) {
                if (findPath(e, target, path)) {
                    path.add(e);
                    return true;
                }
            }
        } else {
            return true;
        }
        return false;
    }

    /**
     * Employee structure is like below.
     *                 Eric
     *         --------------------
     *        /           |        \
     *     David       Dragon     Steve
     *    -------     --------    ------
     *    /    \       /    \        \
     *  Mike  Jack  James  Robin    Cathy
     *  ----  ----  -----  -----
     *   |                    \
     *  John                Helen
     *
     * @return
     */
    public static Employee getCEO() {
        int i = 0;
        Employee ceo = new Employee(0, "Eric");

        Employee cto = new Employee(1, "David");
        Employee cio = new Employee(2, "Dragon");
        Employee cfo = new Employee(3, "Steve");
        ceo.getReports().add(cto);
        ceo.getReports().add(cio);
        ceo.getReports().add(cfo);

        // CTO
        Employee mike = new Employee(4, "Mike");
        Employee jack = new Employee(5, "Jack");
        cto.getReports().add(mike);
        cto.getReports().add(jack);

        //CIO
        Employee james = new Employee(6, "James");
        Employee robin = new Employee(7, "Robin");
        cio.getReports().add(james);
        cio.getReports().add(robin);

        //CFO
        Employee cathy = new Employee(8, "Cathy");
        Employee helen = new Employee(9, "Helen");
        cfo.getReports().add(cathy);


        Employee john = new Employee(10, "John");
        mike.getReports().add(john);
        robin.getReports().add(helen);

        return ceo;
    }

}