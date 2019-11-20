package com.hrms.model;

public class Employee {
    private int empID;
    private String empName;
    private String deptName;
    private String skills;
    private String role;
    public Employee() {
    }

    public Employee(int empID, String empName, String deptName, String skills, String role) {
        this.empID = empID;
        this.empName = empName;
        this.deptName = deptName;
        this.skills = skills;
        this.role = role;
    }

    public int getEmpID() {
        return empID;
    }
    public void setEmpID(int empID) {
        this.empID = empID;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", skills='" + skills + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}