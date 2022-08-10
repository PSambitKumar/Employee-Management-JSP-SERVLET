package com.csm.employeemanagement.entity;

import javax.persistence.*;

@Entity
@Table
public class Qualification {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qualId;
    @Column
    private String qualName;

    public Qualification() {
    }

    public Qualification(int qualId, String qualName) {
        this.qualId = qualId;
        this.qualName = qualName;
    }

    public int getQualId() {
        return qualId;
    }

    public void setQualId(int qualId) {
        this.qualId = qualId;
    }

    public String getQualName() {
        return qualName;
    }

    public void setQualName(String qualName) {
        this.qualName = qualName;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "qualId=" + qualId +
                ", qualName='" + qualName + '\'' +
                '}';
    }
}
