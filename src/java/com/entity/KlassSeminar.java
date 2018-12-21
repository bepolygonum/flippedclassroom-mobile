package com.entity;

import java.sql.Timestamp;

public class KlassSeminar {
    private int id;
    private int klass_id;
    private int seminar_id;
    private Timestamp report_ddl;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKlass_id() {
        return klass_id;
    }

    public void setKlass_id(int klass_id) {
        this.klass_id = klass_id;
    }

    public int getSeminar_id() {
        return seminar_id;
    }

    public void setSeminar_id(int seminar_id) {
        this.seminar_id = seminar_id;
    }

    public Timestamp getReport_ddl() {
        return report_ddl;
    }

    public void setReport_ddl(Timestamp report_ddl) {
        this.report_ddl = report_ddl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
