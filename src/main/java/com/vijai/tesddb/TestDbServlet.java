package com.vijai.tesddb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Victor on 14.03.2017.
 */
@WebServlet(name = "TestDbServlet")
public class TestDbServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // setup connection variables
         String dbUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
         String user = "springstudent";
         String pass = "springstudent";
         String driver = "com.mysql.jdbc.Driver";

         // create connection


        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to DB: " + dbUrl);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbUrl, user, pass);
            out.println("Connection SUCCESSFULL");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
