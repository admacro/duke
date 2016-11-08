package com.jamesni.interview;

import java.util.ArrayList;

/**
 * Created by james on 10/19/16.
 */
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
}
