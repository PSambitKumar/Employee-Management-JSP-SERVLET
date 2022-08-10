package com.csm.employeemanagement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Employee implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column
    private String empCode;
    @Column
    private String empName;
    @Column
    private Long empPhn;
    @Column
    private String empEmail;
    @Column
    private Date empDob;
    @Column
    private String empGender;

    @Column
    private Date empApplyDate;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country empNationality;
    @ManyToOne
    @JoinColumn(name = "relegion_id")
    private Religion empReligion;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empCode='" + empCode + '\'' +
                ", empName='" + empName + '\'' +
                ", empPhn=" + empPhn +
                ", empEmail='" + empEmail + '\'' +
                ", empDob=" + empDob +
                ", empGender='" + empGender + '\'' +
                ", empApplyDate=" + empApplyDate +
                ", empNationality=" + empNationality +
                ", empReligion=" + empReligion +
                ", empQualification=" + empQualification +
                ", permanentAddress=" + permanentAddress +
                '}';
    }

    public Date getEmpApplyDate() {
        return empApplyDate;
    }

    public void setEmpApplyDate(Date empApplyDate) {
        this.empApplyDate = empApplyDate;
    }

    public Qualification getEmpQualification() {
        return empQualification;
    }

    public void setEmpQualification(Qualification empQualification) {
        this.empQualification = empQualification;
    }

    @ManyToOne
    @JoinColumn(name = "qual_id")
    private Qualification empQualification;
    @ManyToOne
    @JoinColumn(name = "per_id")
    private PermanentAddress permanentAddress;


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Long getEmpPhn() {
        return empPhn;
    }

    public void setEmpPhn(Long empPhn) {
        this.empPhn = empPhn;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Date getEmpDob() {
        return empDob;
    }

    public void setEmpDob(Date empDob) {
        this.empDob = empDob;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public Country getEmpNationality() {
        return empNationality;
    }

    public void setEmpNationality(Country empNationality) {
        this.empNationality = empNationality;
    }

    public Religion getEmpReligion() {
        return empReligion;
    }

    public void setEmpReligion(Religion empReligion) {
        this.empReligion = empReligion;
    }

    public PermanentAddress getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(PermanentAddress permanentAddress) {
        this.permanentAddress = permanentAddress;
    }


}
