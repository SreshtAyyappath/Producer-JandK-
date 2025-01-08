package com.karix.polling.source;

import jakarta.persistence.*;

@Entity
@Table(name = "SourceTable1")
public class SourceEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEMPLATE_ID")
    private String templateID;

    @Column(name = "MOBILE_NO")
    private String mobileNo;

    @Column(name = "STATUS")
    private Integer status;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    public String getParameter4() {
        return parameter4;
    }

    public void setParameter4(String parameter4) {
        this.parameter4 = parameter4;
    }

    public String getParameter5() {
        return parameter5;
    }

    public void setParameter5(String parameter5) {
        this.parameter5 = parameter5;
    }

    public String getParameter10() {
        return parameter10;
    }

    public void setParameter10(String parameter10) {
        this.parameter10 = parameter10;
    }

    public String getParameter8() {
        return parameter8;
    }

    public void setParameter8(String parameter8) {
        this.parameter8 = parameter8;
    }

    public String getParameter9() {
        return parameter9;
    }

    public void setParameter9(String parameter9) {
        this.parameter9 = parameter9;
    }

    public String getParameter6() {
        return parameter6;
    }

    public void setParameter6(String parameter6) {
        this.parameter6 = parameter6;
    }

    public String getParameter7() {
        return parameter7;
    }

    public void setParameter7(String parameter7) {
        this.parameter7 = parameter7;
    }

    public String getTemplateID() {
        return templateID;
    }

    public void setTemplateID(String templateID) {
        this.templateID = templateID;
    }

    @Column(name = "PARAMETER1")
    private String parameter1;

    @Column(name = "PARAMETER2")
    private String parameter2;

    @Column(name = "PARAMETER3")
    private String parameter3;

    @Column(name = "PARAMETER4")
    private String parameter4;

    @Column(name = "PARAMETER5")
    private String parameter5;

    @Column(name = "PARAMETER6")
    private String parameter6;

    @Column(name = "PARAMETER7")
    private String parameter7;

    @Column(name = "PARAMETER8")
    private String parameter8;

    @Column(name = "PARAMETER9")
    private String parameter9;

    @Column(name = "PARAMETER10")
    private String parameter10;

}
