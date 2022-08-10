package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Qualification;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class saveQualification extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();
        Qualification qualification = new Qualification();

        qualification.setQualName(request.getParameter("inputQualification"));
        Transaction tx = session.beginTransaction();

        if(request.getParameter("inputId") !="") {
            qualification.setQualId(Integer.parseInt(request.getParameter("inputId")));
            session.update(qualification);
        }
        else {
            session.save(qualification);
        }
        tx.commit();

        response.sendRedirect("/addQualification");
    }
}
