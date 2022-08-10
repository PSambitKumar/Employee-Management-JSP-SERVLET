package com.csm.employeemanagement.controller;

import com.csm.employeemanagement.dbconfig.DBConfig;
import com.csm.employeemanagement.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class saveEmployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maxId = 0;
        String code = "JV00";
        Session session = DBConfig.getSessionFactory().openSession();
        Employee employee = new Employee();
        PermanentAddress permanentAddress = new PermanentAddress();

        employee.setEmpName(request.getParameter("inputName"));
        employee.setEmpPhn(Long.parseLong(request.getParameter("inputMobile")));
        employee.setEmpEmail(request.getParameter("inputEmail"));
        employee.setEmpDob(Date.valueOf(request.getParameter("inputDob")));
        employee.setEmpGender(request.getParameter("inputGender"));
        employee.setEmpApplyDate(new java.util.Date());


        Query query = session.createQuery("From Country");
        List<Country> countryList = query.list();
        request.setAttribute("countryList", countryList);

        for (Country country: countryList) {
            if (country.getCid()==Integer.parseInt(request.getParameter("inputNationality"))){
                employee.setEmpNationality(country);
                break;
            }
        }

        Query query1 = session.createQuery("From Religion");
        List<Religion> religionList = query1.list();
        request.setAttribute("religionList", religionList);

        for (Religion religion: religionList) {
            if (religion.getRid()==Integer.parseInt(request.getParameter("inputReligion"))){
                employee.setEmpReligion(religion);
                break;
            }
        }

        Query query2 = session.createQuery("From Qualification");
        List<Qualification> qualificationList = query2.list();
        request.setAttribute("qualificationList", qualificationList);

        for (Qualification qualification: qualificationList) {
            if (qualification.getQualId()==Integer.parseInt(request.getParameter("inputQualification"))){
                employee.setEmpQualification(qualification);
                break;
            }
        }

        permanentAddress.setStreet(request.getParameter("inputStreet"));
        permanentAddress.setCity(request.getParameter("inputCity"));

        Query query4 = session.createQuery("From Country");
        List<Country> countryList1 = query4.list();
        request.setAttribute("countryList1", countryList1);

        for (Country country: countryList1) {
            if (country.getCid()==Integer.parseInt(request.getParameter("inputCountry"))){
                permanentAddress.setCountry(country);
                break;
            }
        }

        Query query5 = session.createQuery("From State ");
        List<State> stateList = query5.list();
        request.setAttribute("stateList", stateList);

        for (State state: stateList) {
            if (state.getSid()==Integer.parseInt(request.getParameter("inputState"))){
                permanentAddress.setState(state);
                break;
            }
        }

        permanentAddress.setPincode(Integer.parseInt(request.getParameter("inputPin")));
        employee.setPermanentAddress(permanentAddress);

//        Query query1 = session.createQuery("SELECT MAX(empId)  From Employee ");
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
           PreparedStatement ps = con.prepareStatement("SELECT MAX(empId) FROM employee");
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               maxId = rs.getInt(1);
           }
       }catch (Exception e){
           e.printStackTrace();
       }

        Transaction tx = session.beginTransaction();
        if(request.getParameter("inputId") !="") {
            employee.setEmpId(Integer.parseInt(request.getParameter("inputId")));
            session.update(employee);
        }
        else {
            if (maxId == 0) {
                employee.setEmpCode(code+1);
            }
            else{
                employee.setEmpCode(code+(maxId+1));
            }
            session.save(employee);
            session.save(permanentAddress);
        }
        tx.commit();

        response.sendRedirect("/addEmployee");
    }
}
