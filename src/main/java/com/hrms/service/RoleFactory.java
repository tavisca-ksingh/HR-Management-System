package com.hrms.service;

import com.hrms.businessLogic.EmployeeBL;
import com.hrms.businessLogic.HRBL;
import com.hrms.businessLogic.ReviewerBL;
import com.hrms.model.Employee;

import java.util.Scanner;

public class RoleFactory {

   public static Object getRole(){
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter Role");
        String role = sc.nextLine();

        if(role.equalsIgnoreCase("HR")){
            return new HRBL();
        }
        else if(role.equalsIgnoreCase("Reviewer")){
            return new ReviewerBL();
        }
        else{
            return  new EmployeeBL();
        }

    }
}
