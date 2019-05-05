package com.vip.jdk12.example;

public class Employee {
    private int id;
    private String name;
    private String designation;
    private int experienceYears;

    public Employee(int id, String name, String designation, int experienceYears) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.experienceYears = experienceYears;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}
