package com.hrms.businessLogic;

import com.hrms.dao.DBHelper;
import com.hrms.model.Employee;

import java.util.Scanner;

public class HRBL extends EmployeeBL {

    private DBHelper dbHelper = new DBHelper();
    public void addEmployee() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter emp id");
        int empID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter emp name");
        String empName = sc.nextLine();
        System.out.println("Enter emp Department Name");
        String deptName = sc.nextLine();
        System.out.println("Enter emp Skills");
        String skills = sc.nextLine();
        System.out.println("Enter emp Role");
        String role = sc.nextLine();
        Employee employee = new Employee(empID,empName,deptName,skills,role);
        DBHelper dbHelper = new DBHelper();
        dbHelper.insertEmployeeData(empID,empName,deptName,skills,role);

    }


    public void deleteEmployee(int empID){
        if(dbHelper.addEmployeeToHistory(empID)){
            dbHelper.deleteEmployee(empID);
        }
        System.out.println("Deletion not took place!!");
    }

    public void seeHistory(){
        String query = "select * from OldEmployees";
       // dbHelper.seeHistory();
    }

    public void seeReportSummary(String departmentName){
        String query = "select employee.empID, employee.empName, rating, remarks from pa_form join employee where employee.empID = pa_form.empID and employee.department =" + departmentName;
        dbHelper.seeReportSummary(query);
    }

}
