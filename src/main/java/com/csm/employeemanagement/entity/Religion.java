package com.csm.employeemanagement.entity;

import javax.persistence.*;

@Entity
@Table
public class Religion {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    @Column
    private String rname;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Religion{" +
                "rid=" + rid +
                ", rname=" + rname +
                '}';
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
