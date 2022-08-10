package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Country;
import com.csm.employeemanagement.entity.Qualification;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class saveCountry extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();
        Country country = new Country();

        country.setCname(request.getParameter("inputCountry"));
        Transaction tx = session.beginTransaction();

        if(request.getParameter("inputId") !="") {
            country.setCid(Integer.parseInt(request.getParameter("inputId")));
            session.update(country);
        }
        else {
            session.save(country);
        }
        tx.commit();

        response.sendRedirect("/addCountry");
    }
}
