package com.karix.polling.source;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TemplateTable")
public class TemplateEntity {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TEMPLATE_TXT")
    private String templateTxt;

    @Column(name = "DLT_TMPID")
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateTxt() {
        return templateTxt;
    }

    public void setTemplateTxt(String templateTxt) {
        this.templateTxt = templateTxt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
