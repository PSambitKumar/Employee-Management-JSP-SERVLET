package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Country;
import com.csm.employeemanagement.entity.State;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "saveState", value = "/saveState")
public class saveState extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();
        State state = new State();

        state.setSname(request.getParameter("inputState"));

        Query query1 = session.createQuery("From Country");
        List<Country> countryList = query1.list();
        request.setAttribute("countryList", countryList);

        for (Country country: countryList) {
            if (country.getCid()==Integer.parseInt(request.getParameter("inputCountry"))){
                state.setCountry(country);
            }
        }

        Transaction tx = session.beginTransaction();

        if(request.getParameter("inputId") !="") {
            state.setSid(Integer.parseInt(request.getParameter("inputId")));
            session.update(state);
        }
        else {
            session.save(state);
        }
        tx.commit();

        response.sendRedirect("/addState");
    }
}
