package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Country;
import com.csm.employeemanagement.entity.Religion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "saveReligion", value = "/saveReligion")
public class saveReligion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();
        Religion religion = new Religion();

        religion.setRname(request.getParameter("inputReligion"));

        Transaction tx = session.beginTransaction();

        if(request.getParameter("inputId") !="") {
            religion.setRid(Integer.parseInt(request.getParameter("inputId")));
            session.update(religion);
        }
        else {
            session.save(religion);
        }
        tx.commit();

        response.sendRedirect("/addReligion");
    }
}
