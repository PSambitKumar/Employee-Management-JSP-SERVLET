package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class addEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();

        Query query = session.createQuery("From Country ");
        List<Country> countryList = query.list();
        request.setAttribute("countryList", countryList);

        Query query1 = session.createQuery("From State ");
        List<State> stateList = query1.list();
        request.setAttribute("stateList", stateList);

        Query query2 = session.createQuery("From Religion ");
        List<Religion> religionList = query2.list();
        request.setAttribute("religionList", religionList);

        Query query3 = session.createQuery("From Employee ");
        List<Employee> employeeList = query3.list();
        request.setAttribute("employeeList", employeeList);

        Query query4 = session.createQuery("From Qualification ");
        List<Qualification> qualificationList = query4.list();
        request.setAttribute("qualificationList", qualificationList);

        request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
    }
}
