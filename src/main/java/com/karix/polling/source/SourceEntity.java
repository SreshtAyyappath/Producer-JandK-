package com.karix.polling.source;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "SourceTable1")
public class SourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private BigDecimal id;

    @Column(name = "ENTRY_TIME")
    private Timestamp entryTime;

    @Column(name = "PROCESS_TIME")
    private Timestamp processTime;

    @Column(name = "MOBILE_NO", length = 15)
    private String mobileNo;

    @Column(name = "TEMPLATE_ID", nullable = false)
    private BigDecimal templateID;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "ALERT_TYPE")
    private Integer alertType;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;

    @Column(name = "PARAMETER1", length = 50)
    private String parameter1;

    @Column(name = "PARAMETER2", length = 50)
    private String parameter2;

    @Column(name = "PARAMETER3", length = 50)
    private String parameter3;

    @Column(name = "PARAMETER4", length = 50)
    private String parameter4;

    @Column(name = "PARAMETER5", length = 50)
    private String parameter5;

    @Column(name = "PARAMETER6", length = 50)
    private String parameter6;

    @Column(name = "PARAMETER7", length = 50)
    private String parameter7;

    @Column(name = "PARAMETER8", length = 50)
    private String parameter8;

    @Column(name = "PARAMETER9", length = 50)
    private String parameter9;

    @Column(name = "PARAMETER10", length = 50)
    private String parameter10;

    @Column(name = "UNIQUE_ID", nullable = false, length = 32)
    private String uniqueId;

    @Column(name = "TRAN_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column(name = "TRAN_ID", length = 9)
    private String transactionId;

    @Column(name = "PART_TRAN_SRL_NUM", length = 4)
    private String partTransactionSerialNumber;

    // Getters and Setters

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public Timestamp getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Timestamp processTime) {
        this.processTime = processTime;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public BigDecimal getTemplateID() {
        return templateID;
    }

    public void setTemplateID(BigDecimal templateID) {
        this.templateID = templateID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAlertType() {
        return alertType;
    }

    public void setAlertType(Integer alertType) {
        this.alertType = alertType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
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

    public String getParameter10() {
        return parameter10;
    }

    public void setParameter10(String parameter10) {
        this.parameter10 = parameter10;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPartTransactionSerialNumber() {
        return partTransactionSerialNumber;
    }

    public void setPartTransactionSerialNumber(String partTransactionSerialNumber) {
        this.partTransactionSerialNumber = partTransactionSerialNumber;
    }
}
