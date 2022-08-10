package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Country;
import com.csm.employeemanagement.entity.Employee;
import com.csm.employeemanagement.entity.State;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewEmployee", value = "/viewEmployee")
public class viewEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createQuery("From Employee ");
        List<Employee> employeeList = query.list();
        request.setAttribute("employeeList", employeeList);

        request.getRequestDispatcher("viewEmployee.jsp").forward(request, response);
    }
}
