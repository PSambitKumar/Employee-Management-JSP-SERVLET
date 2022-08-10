package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Qualification;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class addQualification extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createQuery("From Qualification ");
        List<Qualification> qualificationList = query.list();
        request.setAttribute("qualificationList", qualificationList);

        request.getRequestDispatcher("addQualification.jsp").forward(request, response);
    }
}
