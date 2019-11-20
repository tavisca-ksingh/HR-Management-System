package com.hrms.businessLogic;

import com.hrms.dao.DBHelper;

public class ReviewerBL {

    private DBHelper dbHelper = null;

    public boolean editPAForm(int empID, String remark){
        return dbHelper.updateToPAFormTable(empID,remark);
    }

    public void seeReportSummary(String departmentName){
        dbHelper.seeReportSummary(departmentName);
    }

}
