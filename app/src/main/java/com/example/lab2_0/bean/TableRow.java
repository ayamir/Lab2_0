package com.example.lab2_0.bean;

public class TableRow {
    private final String id;
    private String name;
    private String gender;
    private String department;
    private String salary;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void cover(TableRow other) {
        setName(other.getName());
        setGender(other.getGender());
        setDepartment(other.getDepartment());
        setSalary(other.getSalary());
    }
}
