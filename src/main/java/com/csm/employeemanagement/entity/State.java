package com.csm.employeemanagement.entity;

import javax.persistence.*;

@Entity
@Table
public class State {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    @Column
    private String sname;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Override
    public String toString() {
        return "State{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", country=" + country +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}