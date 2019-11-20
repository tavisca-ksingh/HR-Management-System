package com.hrms.businessLogic;

import com.hrms.dao.DBHelper;

public  class EmployeeBL {

    private DBHelper dbHelper = new DBHelper();

    public void viewProfile(int empID){
        dbHelper.viewProfile(empID);
    }

    public void updateProfile(int empID, String columnToUpdate, String newColumnContent){
        dbHelper.updateProfile(empID,columnToUpdate,newColumnContent);
    }

    public boolean fillPAForm(int empID, double rating, String remarks){
        return dbHelper.insertToPAFormTAble( empID, rating, remarks);
    }

    public boolean  validateEmployee(int id){
        return dbHelper.checkEmployee( id);
    }


}
