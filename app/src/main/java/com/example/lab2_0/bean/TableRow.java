package com.example.lab2_0.bean;

public class TableRow {
    private final String id;
    private final String name;
    private final String gender;
    private final String department;
    private final String salary;

    public TableRow(String id, String name, String gender, String department, String salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public String getSalary() {
        return salary;
    }

}
