package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Country;
import com.csm.employeemanagement.entity.State;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "addState", value = "/addState")
public class addState extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createQuery("From State");
        List<State> stateList = query.list();
        request.setAttribute("stateList", stateList);


        Query query1 = session.createQuery("From Country");
        List<Country> countryList = query1.list();
        request.setAttribute("countryList", countryList);



        request.getRequestDispatcher("addState.jsp").forward(request, response);
    }
}
