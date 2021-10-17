package xyz.admacro.interview.amazon;

import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private ArrayList<Employee> reports = new ArrayList<>();

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Employee> getReports() {
        return reports;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
