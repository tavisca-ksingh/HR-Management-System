package com.hrms.main;

import com.hrms.businessLogic.EmployeeBL;
import com.hrms.businessLogic.HRBL;
import com.hrms.businessLogic.ReviewerBL;
import com.hrms.service.RoleFactory;

import java.util.Scanner;

public class HRMSMain {

    public static void main(String[] args) {
           mainMenu();
    }

    public static  void mainMenu(){
        Object role = RoleFactory.getRole();

        if(role instanceof HRBL){
            hrTask((HRBL)role);
        }
        else if(role instanceof ReviewerBL){
            reviewrTask((ReviewerBL)role);
        }
        else {
            employeeTask((EmployeeBL)role);
        }
    }

    public static void hrTask(HRBL hr) {
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.println("1. Add Employee \n" +
                    "2. Remove Employee \n" +
                    "3. See History \n" +
                    "4 . Main menu \n"
            );

            n= sc.nextInt();
            sc.nextLine();
            switch (n){
                case  1:
                    hr.addEmployee();
                    break;
                case  2 :
                    System.out.println("Enter employee ID to delete");
                    int empID=  sc.nextInt();
                    hr.deleteEmployee(empID);
                    break;
                case 3:
                    hr.seeHistory();
                    break;
                case 4:
                    mainMenu();
                    break;
            }
        }while (n>0 && n<5);
    }

    public static void reviewrTask(ReviewerBL reviewer) {
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.println("1. Edit PA Form \n" +
                    "2. See Summary \n"+
                    "3 . Main menu \n"
            );
            n= sc.nextInt();
            sc.nextLine();
            switch (n){
                case  1:
                    System.out.println("Enter Employee Id");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Remark");
                    String remark = sc.nextLine();
                    reviewer.editPAForm(id,remark);
                    break;
                case  2 :
                    System.out.println("Enter Department : ");
                    String dept = sc.nextLine();
                    reviewer.seeReportSummary(dept);
                    break;
                case 3:
                    mainMenu();
                    break;
            }
        }while (n>0 && n<4);
    }

    public static void employeeTask(EmployeeBL emp){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Employee Id");
        int id = sc.nextInt();
       if( emp.validateEmployee(id)){
           int n;
           do{
               System.out.println("1. View Profile \n" +
                       "2. Update Profile \n"+
                       "3. Fill PA Form \n" +
                       "4. Main menu \n"
               );
               n= sc.nextInt();
               sc.nextLine();
               switch (n){
                   case  1:
                     emp.viewProfile(id);
                       break;
                   case 2:
                       System.out.println("Enter Column Name to update");
                       String columName = sc.nextLine();
                       System.out.println("Enter the Value");
                       String content = sc.nextLine();
                       emp.updateProfile(id,columName,content);
                       break;
                   case 3:
                       System.out.println("Enter the Rating");
                       double rating = sc.nextDouble();
                       sc.nextLine();
                       System.out.println("Enter the Rating");
                       String remark = sc.nextLine();
                       emp.fillPAForm(id,rating,remark);
                       break;
                   case 4:
                       mainMenu();
                       break;
               }
           }while (n>0 && n<4);
       }
       else {
           System.out.println("No Employee Found");
       }
    }
}
