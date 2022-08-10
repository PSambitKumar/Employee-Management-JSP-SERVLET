package com.csm.employeemanagement.dbconfig;

import com.csm.employeemanagement.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {
    public static SessionFactory sessionfactory;

    public static SessionFactory getSessionFactory() {

        if(sessionfactory == null) {
            Configuration conf =new Configuration();
            conf.addAnnotatedClass(Qualification.class);
            conf.addAnnotatedClass(Country.class);
            conf.addAnnotatedClass(State.class);
            conf.addAnnotatedClass(Religion.class);
            conf.addAnnotatedClass(PermanentAddress.class);
            conf.addAnnotatedClass(Employee.class);
            sessionfactory = conf.buildSessionFactory();
        }
        return sessionfactory;
    }
}

