package com.hrms.dao;

import java.sql.*;

public class DBHelper {
    DBConnector dbConnector = new DBConnector();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection connection = null;

    public boolean insertToPAFormTAble(int empID, double rating, String remarks){
        connection = dbConnector.connectToDB();
        try {
            preparedStatement = connection.prepareStatement("insert into pa_form values (?, ?, ?)");
            preparedStatement.setInt(1, empID);
            preparedStatement.setDouble(2, rating);
            preparedStatement.setString(3, remarks);
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount!=0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkEmployee(int empID){
        connection = dbConnector.connectToDB();
        try {
            statement = connection.createStatement();
            boolean check = statement.execute("select * from employee where empID = " + empID);
            if(check) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateToPAFormTable(int empID, String remark){
        connection = dbConnector.connectToDB();
        try {
            statement = connection.createStatement();
            int rowCount = statement.executeUpdate("update pa_form set remarks = " + remark + "where empID = " + empID);
            if(rowCount!=0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addEmployeeToHistory(int empID) {
        connection = dbConnector.connectToDB();
        String query = "select employee.empID, employee.empName, employee.department, employee.skills, pa_form.rating, " +
                "employee.role from employee join pa_form where employee.empID = pa_form.empID and " +
                "employee.empID = " + empID;
        String query2 = "insert into OldEmployees values (?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, resultSet.getInt(1));
            preparedStatement.setString(2, resultSet.getString(2));
            preparedStatement.setString(3, resultSet.getString(3));
            preparedStatement.setString(4, resultSet.getString(4));
            preparedStatement.setDouble(5, resultSet.getDouble(5));
            preparedStatement.setString(6, resultSet.getString(6));
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount!=0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmployee(int empID) {
        String query = "delete from employee where empID = " + empID;
        connection = dbConnector.connectToDB();
        try {
            statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
            if(rowCount != 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void seeReportSummary(String departmentName) {
       String query = "select employee.empID, employee.empName, rating, remarks from pa_form join employee where employee.empID = pa_form.empID and employee.department =" + departmentName;
        connection = dbConnector.connectToDB();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                System.out.println("EmployeeID: " + resultSet.getInt(1));
                System.out.println("EmployeeName: " + resultSet.getString(2));
                System.out.println("Rating: " + resultSet.getDouble(3));
                System.out.println("Remarks: " + resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewProfile(int empID){
        connection = dbConnector.connectToDB();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "select * from employee where empID = " + empID);
            resultSet.next();
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProfile(int empID, String columnToUpdate, String newColumnContent) {
        String query ="update employee set " + columnToUpdate + "=" + "\'" + newColumnContent+ "\'"+ " where empID = " + empID;
        connection = dbConnector.connectToDB();
        try {
            statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
            if(rowCount!=0) System.out.println("Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEmployeeData(int empID, String empName, String deptName, String skills, String role) {
        connection = dbConnector.connectToDB();
        try {
            preparedStatement = connection.prepareStatement("insert into employee values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, empID);
            preparedStatement.setString(2, empName);
            preparedStatement.setString(3, deptName);
            preparedStatement.setString(4, skills);
            preparedStatement.setString(5, role);
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount!=0) System.out.println("Employee Added");;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}