package com.project;

import java.sql.*;
import java.util.Scanner;


public class ProjectAccountingApplication {

private ProjectAccountingApplication() {}

    public static Connection connection() {
            // Connection to DataBase MySQL
            Connection con = null;
            String url = "jdbc:mysql://localhost:3306/AccountingOfStudents";
            String user= "root";
            String password = "";

            try {
                // Try to connect
                con = DriverManager.getConnection(url, user, password);

                System.out.println("Connection with DataBase success");

            }   catch (Exception ex) {

                System.out.println("Connection with DataBase deny");

            }   return con;
        }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
            System.out.println("Connection has closed");
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewValue() {

    Connection con = ProjectAccountingApplication.connection();
    String sql = "SELECT * FROM aboutofstudents";
    Statement sta = null;

    try {
        sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }
        sta.close();
        rs.close();

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ISSUE WITH viewValue");

    } finally {
        try {
            con.close();
            System.out.println("Connection close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

    public static void insertValue() {
        System.out.println("Insert name");
        Scanner sc = new Scanner(System.in);

        //int idStudent = sc.nextInt();
        String Name1 = sc.next();

        Connection con = ProjectAccountingApplication.connection();

        String sql = "INSERT INTO aboutofstudents (Name) VALUES(\'"+Name1+"\');";
        //System.out.println(sql);
        Statement sta = null;

        try {
            sta = con.createStatement();
            int result = sta.executeUpdate(sql);
            if (result != 0) {
                System.out.println("Operation has completed");
            }
            sta.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ann error occurred during of operation");
        } finally {
            try {
                sta.close();
                System.out.println("Connection to DB closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteValues() {
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        int id = scanner.nextInt();

        String sql_delete = "delete FROM aboutofstudents WHERE idStudent = "+ id +";";

        try {
            con = ProjectAccountingApplication.connection();
            Statement sta = con.createStatement();

            int result = sta.executeUpdate(sql_delete);

            if (result !=0) {
                System.out.println("Operation successful");
            } con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Operation_delete error");
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void UpdateStatement() {
        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();
        String name = scanner.next();

        String sql_update = "Update aboutofstudents SET Name = \'"+name+"\' WHERE idStudent = "+ id +";";

        Connection con = null;
        Statement sta = null;

        try {
            con = ProjectAccountingApplication.connection();
            sta = con.createStatement();

            int result = sta.executeUpdate(sql_update);

            sta.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

public static void main(String[] args) {
    //ProjectAccountingApplication.insertValue();
    //ProjectAccountingApplication.insertValue();
    ProjectAccountingApplication.UpdateStatement();
}

}




