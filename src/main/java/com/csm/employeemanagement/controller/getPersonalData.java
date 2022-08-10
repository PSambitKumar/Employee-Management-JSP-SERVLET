package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.Country;
import com.csm.employeemanagement.entity.Employee;
import net.bytebuddy.matcher.ElementMatcher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "getPersonalData", value = "/getPersonalData")
public class getPersonalData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("empId");
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createQuery("From Employee  as  emp WHERE  emp.empId="+data);
        Employee employee = (Employee)query.uniqueResult();
        response.getWriter().println("Name : " + employee.getEmpName() +
                "\nEmployee Code : " + employee.getEmpCode() +
                "\nEmployee Phone Number : " + employee.getEmpPhn() +
                "\nEmployee Email Address : " + employee.getEmpEmail() +
                "\nEmployee Date of Birth : " + employee.getEmpDob() +
                "\nEmployee Nationality : " + employee.getEmpNationality().getCname() +
                "\nEmployee Religion : " + employee.getEmpReligion().getRname() +
                "\nEmployee Gender : " + employee.getEmpGender() +
                "\nEmployee Address: \n "+ "Employee Street : " + employee.getPermanentAddress().getStreet() +
                "\nEmployee City : " + employee.getPermanentAddress().getCity() +
                "\nEmployee State : " + employee.getPermanentAddress().getState().getSname() +
                "\nEmployee Country : " + employee.getPermanentAddress().getCountry() +
                "\nEmployee PinCode : " + employee.getPermanentAddress().getPincode());
    }
}
