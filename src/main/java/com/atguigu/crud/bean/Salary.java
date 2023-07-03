package com.atguigu.crud.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Salary {
    private Integer id;

    private Integer deptId;

    private Integer empId;

    private BigDecimal jsalary;

    private BigDecimal jbonus;

    private String isgrant;

    private Date grantdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public BigDecimal getJsalary() {
        return jsalary;
    }

    public void setJsalary(BigDecimal jsalary) {
        this.jsalary = jsalary;
    }

    public BigDecimal getJbonus() {
        return jbonus;
    }

    public void setJbonus(BigDecimal jbonus) {
        this.jbonus = jbonus;
    }

    public String getIsgrant() {
        return isgrant;
    }

    public void setIsgrant(String isgrant) {
        this.isgrant = isgrant == null ? null : isgrant.trim();
    }

    public Date getGrantdate() {
        return grantdate;
    }

    public void setGrantdate(Date grantdate) {
        this.grantdate = grantdate;
    }
}