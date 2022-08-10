package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Country;
import com.csm.employeemanagement.entity.Religion;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addReligion", value = "/addReligion")
public class addReligion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createQuery("From Religion ");
        List<Religion> religionList = query.list();
        request.setAttribute("religionList", religionList);

        request.getRequestDispatcher("addReligion.jsp").forward(request, response);
    }
}
