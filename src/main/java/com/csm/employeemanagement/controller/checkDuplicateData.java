package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "checkDuplicateData", value = "/checkDuplicateData")
public class checkDuplicateData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String result = "";

        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createQuery("From Employee");
        List<Employee> employeeList = query.list();

        for (Employee employee : employeeList) {
            if (employee.getEmpName().equalsIgnoreCase(name)) {
                result = "Found";
                break;
            }
            else{
                result = "NotFound";
            }
        }
        response.getWriter().println(result);
    }
}
